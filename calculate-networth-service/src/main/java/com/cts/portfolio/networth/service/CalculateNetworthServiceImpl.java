package com.cts.portfolio.networth.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.cts.portfolio.networth.dto.AssetDetailsDto;
import com.cts.portfolio.networth.dto.AssetSellDetailsDto;
import com.cts.portfolio.networth.exception.AuthenticationFailiureException;
import com.cts.portfolio.networth.exception.SellCountOverLimitException;
import com.cts.portfolio.networth.model.AssetDetails;
import com.cts.portfolio.networth.model.AssetSellDetails;
import com.cts.portfolio.networth.model.AuthResponse;
import com.cts.portfolio.networth.repository.CalculateNetworthPortfolioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculateNetworthServiceImpl implements CalculateNetworthService {

	@Autowired
	CalculateNetworthPortfolioRepository networthRepo;

	@Autowired
	RestTemplate rt;

	private static final String HEADER = "Authorization";

	public AssetSellDetails assetSellDetailsDtoToAssetSellDetails(AssetSellDetailsDto assetSellDetailsDto) {
		/**
		 * @param an object of type assetSellDetailsDto
		 * @return this method will return the object of type assetSellDetails after
		 *         converting the assetSellDetailsDto object.
		 * 
		 */
		var assetSellDetails = new AssetSellDetails();
		assetSellDetails.setId(assetSellDetailsDto.getId());
		assetSellDetails.setAssetId(assetSellDetailsDto.getAssetId());
		assetSellDetails.setCount(assetSellDetailsDto.getCount());
		return assetSellDetails;
	}

	public AssetSellDetailsDto assetSellDetailsToAssetSellDetailsDto(AssetSellDetails assetSellDetails) {
		/**
		 * @param an object of type AssetSellDetails
		 * @return this method will return the object of type AssetSellDetailsDto after
		 *         converting the assetSellDetails object.
		 * 
		 */
		var assetSellDetailsDto = new AssetSellDetailsDto();
		assetSellDetailsDto.setId(assetSellDetails.getId());
		assetSellDetailsDto.setAssetId(assetSellDetails.getAssetId());
		assetSellDetailsDto.setCount(assetSellDetails.getCount());
		return assetSellDetailsDto;
	}

	public AssetDetails assetDetailsDtoToAssetDetails(AssetDetailsDto assetDetailsDto) {
		/**
		 * @param an object of type assetDetailsDto
		 * @return this method will return the object of type assetDetails after
		 *         converting the assetDetailsDto object.
		 * 
		 */
		var assetDetails = new AssetDetails();
		assetDetails.setId(assetDetailsDto.getId());
		assetDetails.setPortfolioId(assetDetailsDto.getPortfolioId());
		assetDetails.setAssetType(assetDetailsDto.getAssetType());
		assetDetails.setAssetId(assetDetailsDto.getAssetId());
		assetDetails.setCount(assetDetailsDto.getCount());
		return assetDetails;
	}

	public AssetDetailsDto assetDetailsToAssetDetailsDto(AssetDetails assetDetails) {
		/**
		 * @param an object of type AssetDetails
		 * @return this method will return the object of type AssetDetailsDto after
		 *         converting the assetDetails object.
		 * 
		 */
		var assetDetailsDto = new AssetDetailsDto();
		assetDetailsDto.setId(assetDetails.getId());
		assetDetailsDto.setPortfolioId(assetDetails.getPortfolioId());
		assetDetailsDto.setAssetType(assetDetails.getAssetType());
		assetDetailsDto.setAssetId(assetDetails.getAssetId());
		assetDetailsDto.setCount(assetDetails.getCount());
		return assetDetailsDto;
	}

	@Transactional
	public List<AssetDetailsDto> getAllAssetForPortfolio(int id) {
		log.info("Start getAllAssetForPortfolio");
		List<AssetDetails> assetDetailsList = networthRepo.findByPortfolioIdOrderByAssetId(id);
		List<AssetDetailsDto> assetDetailsDtoList = new ArrayList<>();
		for (AssetDetails assetDetails : assetDetailsList) {
			assetDetailsDtoList.add(assetDetailsToAssetDetailsDto(assetDetails));
		}
		log.info("End");
		return assetDetailsDtoList;
	}

	@Transactional
	public void sellAsset(AssetSellDetailsDto assetSellDetailsDto) throws SellCountOverLimitException {

		log.info("Start sell asset");
		int portfolioId = assetSellDetailsDto.getId();
		String assetId = assetSellDetailsDto.getAssetId();
		var assetDetails = networthRepo.findByPortfolioIdAndAssetId(portfolioId, assetId);
		int existingCount = assetDetails.getCount();
		int sellCount = assetSellDetailsDto.getCount();
		if (sellCount > existingCount) {
			throw new SellCountOverLimitException("Asset sale count can't exceed the available quantity...");
		}
		if (existingCount == sellCount) {
			networthRepo.deleteByPortfolioIdAndAssetId(portfolioId, assetId);
		} else {
			existingCount -= sellCount;
		}
		assetDetails.setCount(existingCount);
		networthRepo.save(assetDetails);
		log.info("End");
	}

	public boolean isSessionValid(String token) {
		var header = new HttpHeaders();
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		header.set(HEADER, token);
		HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<AuthResponse> authResponse = rt.exchange("http://authorization-service/validate", HttpMethod.GET, httpEntity,
				AuthResponse.class);
		if (authResponse != null) {
			log.info("End with exception thrown");
			return true;
		} else {

			log.info("End");
			throw new AuthenticationFailiureException("Exception Thrown-Null Auth Response returned");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Double> findDailySharePriceById(String token, List<String> stockAssetList) {
		log.info("Start findDailySharePriceById");
		var header = new HttpHeaders();
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		header.set(HEADER, token);
		HttpEntity<List<String>> entity = new HttpEntity<>(stockAssetList, header);
		log.info("End");
		return (List<Double>) rt.postForObject("http://daily-share-price-service/daily-share-price/get-stocks-price", entity,
				Collection.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Double> findDailyMutualFundPriceById(String token, List<String> mutualFundAssetList) {
		log.info("Start");
		var header = new HttpHeaders();
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		header.set(HEADER, token);
		HttpEntity<List<String>> entity = new HttpEntity<>(mutualFundAssetList, header);
		log.info("End");
		return (List<Double>) rt.postForObject("http://daily-mutual-fund-price-service/daily-mutual-fund-price/get-mutualfunds-price",
				entity, Collection.class);
	}

}