package com.cts.portfolio.dailyshareprice.service;

import java.util.ArrayList;
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

import com.cts.portfolio.dailyshareprice.dto.StockDetailsDto;
import com.cts.portfolio.dailyshareprice.exception.SessionInvalidException;
import com.cts.portfolio.dailyshareprice.exception.StockNotFoundException;
import com.cts.portfolio.dailyshareprice.model.AuthResponse;
import com.cts.portfolio.dailyshareprice.model.StockDetails;
import com.cts.portfolio.dailyshareprice.repository.StockDetailsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StockDetailsServiceImpl implements StockDetailsService {

	@Autowired
	StockDetailsRepository stockDetailsRepository;

	@Autowired
	RestTemplate rt;

	public StockDetailsDto stockDetailsToStockDetailsDto(StockDetails stockDetails) {
		/**
		 * @return this method will return DTO of stock after converting it from
		 *         stockDetails.
		 *
		 */
		var stockDetailsDto = new StockDetailsDto();
		stockDetailsDto.setStockId(stockDetails.getStockId());
		stockDetailsDto.setStockName(stockDetails.getStockName());
		stockDetailsDto.setStockValue(stockDetails.getStockValue());
		return stockDetailsDto;
	}

	public List<Double> getStockbyIdList(List<String> stockIdList) {
		/**
		 * @param this parameter will take List of stock Ids. it will fetch the prices
		 * @return this method will return the list after making it of type double.
		 */

		log.info("inside getStockbyIdList");

		List<Double> stockValueList = new ArrayList<>();
		List<StockDetails> stockList = new ArrayList<>();
		for (String stockId : stockIdList) {
			stockList.add(stockDetailsRepository.getOne(stockId));
		}
		for (StockDetails stock : stockList) {
			stockValueList.add(stock.getStockValue());
		}
		log.info("Ending getStockbyIdList");

		return stockValueList;
	}

	public boolean isSessionValid(String token) throws SessionInvalidException {

		log.info("Starting isSessionValid");
		var header = new HttpHeaders();
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		header.set("Authorization", token);
		HttpEntity<String> httpEntity = new HttpEntity<>(header);
		ResponseEntity<AuthResponse> authResponse = rt.exchange("http://authorization-service/validate", HttpMethod.GET,
				httpEntity, AuthResponse.class);
		if (authResponse == null) {
			log.info("Ending isSessionValid with exception thrown");
			throw new SessionInvalidException("Exception Thrown-Null Auth Response returned");
		}

		log.info("Ending isSessionValid");
		return true;
	}

	@Transactional
	public StockDetailsDto getStockbyName(String stockName) throws StockNotFoundException {
		/**
		 * @param this parameter will take stock Name.
		 * @return this method will return the DTO of Stock which is available in the
		 *         database.
		 */
		var stockDetails = stockDetailsRepository.findByStockName(stockName);
		if (stockDetails == null) {
			throw new StockNotFoundException("No such Stock found with Name = " + stockName);
		}
		return stockDetailsToStockDetailsDto(stockDetails);
	}

}
