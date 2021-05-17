package com.cts.portfolio.dailymutualfundprice.service;

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

import com.cts.portfolio.dailymutualfundprice.dto.MutualFundDetailsDto;
import com.cts.portfolio.dailymutualfundprice.exception.MutualFundNotFoundException;
import com.cts.portfolio.dailymutualfundprice.exception.SessionInvalidException;
import com.cts.portfolio.dailymutualfundprice.model.AuthResponse;
import com.cts.portfolio.dailymutualfundprice.model.MutualFundDetails;
import com.cts.portfolio.dailymutualfundprice.repository.MutualFundDetailsRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class MutualFundDetailsServiceImpl implements MutualFundDetailsService {

	@Autowired
	MutualFundDetailsRepository mutualFundDetailsrepository;

	@Autowired
	RestTemplate rt;

	private MutualFundDetailsDto mutualFundDetailsToMutualFundDetailsDto(MutualFundDetails mutualFundDetails) {

		/**
		 * @param an object of type MutualFundDetails
		 * @return this method will return the object of type MutualFundDetailsDto after
		 *         converting the mutualFundDetails object.
		 *
		 */
		var mutualFundDetailsDto = new MutualFundDetailsDto();
		mutualFundDetailsDto.setMutualFundId(mutualFundDetails.getMutualFundId());
		mutualFundDetailsDto.setMutualFundName(mutualFundDetails.getMutualFundName());
		mutualFundDetailsDto.setMutualFundValue(mutualFundDetails.getMutualFundValue());
		return mutualFundDetailsDto;
	}

	public List<Double> getMutualFundPriceByIdList(List<String> mutualFundIdList) {
		/**
		 * @param this parameter will take mutualFund List.
		 * @return this method will return the list after making it of type double.
		 */

		log.info("Starting getMutualFundPriceByIdList");
		List<Double> mutualFundValueList = new ArrayList<>();
		List<MutualFundDetails> mutualFundList = mutualFundDetailsrepository.findByMutualFundId(mutualFundIdList);
		for (MutualFundDetails mutualFund : mutualFundList) {
			mutualFundValueList.add(mutualFund.getMutualFundValue());
		}
		log.info("Ending getMutualFundPriceByIdList");
		return mutualFundValueList;
	}

	@Transactional
	public MutualFundDetailsDto getMutualFundByName(String mutualFundName) throws MutualFundNotFoundException {
		/**
		 * @param this parameter will take mutualFund Name.
		 * @return this method will return the DTO of Mutual Fund which is available in
		 *         the database.
		 */
		var mutualFundDetails = mutualFundDetailsrepository.findByMutualFundName(mutualFundName);
		if (mutualFundDetails == null)
			throw new MutualFundNotFoundException("Mutual Fund Not Found with name" + mutualFundName);
		return mutualFundDetailsToMutualFundDetailsDto(mutualFundDetails);
	}

	public boolean isSessionValid(String token) {

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

}
