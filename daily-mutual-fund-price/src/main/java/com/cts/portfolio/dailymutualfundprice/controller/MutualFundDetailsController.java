package com.cts.portfolio.dailymutualfundprice.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.portfolio.dailymutualfundprice.dto.MutualFundDetailsDto;
import com.cts.portfolio.dailymutualfundprice.exception.MutualFundNotFoundException;
import com.cts.portfolio.dailymutualfundprice.service.MutualFundDetailsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/daily-mutual-fund-price")
@Slf4j
public class MutualFundDetailsController {
	@Autowired
	MutualFundDetailsService mutualFundDetailsService;


	@PostMapping("/get-mutualfunds-price")
	public List<Double> getDailyMutualFundPriceNavById(@RequestHeader("Authorization") String token,@RequestBody List<String> mutualFundIdList) throws MutualFundNotFoundException {
		/**
		 * @param token This is the first parameter for doing the authorisation of
		 *              method call.
		 * @Param mutualFundIdList This is the second parameter which will take list of
		 *        String Type.
		 * 		 if token is valid, it will return the mutualFundIdList by calling
		 *         .getMutualFundByIdList of service class. else, it will return null.
		 * @return List of price of the stocks present in mutualFundList
		 */
		log.info("Start getDailyMutualFundPriceNavById");
		if (mutualFundDetailsService.isSessionValid(token)) {
			log.info("Ending getDailyMutualFundPriceNavById");
			return mutualFundDetailsService.getMutualFundPriceByIdList(mutualFundIdList);
		}
		log.info("Ending getDailyMutualFundPriceNavById with null");
		return new ArrayList<>();
	}
	
	@GetMapping("/daily-mutual-fund-nav/name/{mutualFundName}")
	public MutualFundDetailsDto getDailyMutualFundNav(@RequestHeader("Authorization") String token,@PathVariable String mutualFundName) throws MutualFundNotFoundException {
		/**
		 * @param token is the parameter for doing the authorisation of method call.
		 * @return if token is valid, then this method will return the details of Mutual
		 *         Fund which is given in GetMapping by calling the .getMutualFundByName
		 *         of Service Class . else, it will return null.
		 */
		if (mutualFundDetailsService.isSessionValid(token)) {
			return mutualFundDetailsService.getMutualFundByName(mutualFundName);
		}
		return null;
	}

}
