package com.cts.portfolio.dailyshareprice.controller;

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

import com.cts.portfolio.dailyshareprice.dto.StockDetailsDto;
import com.cts.portfolio.dailyshareprice.exception.SessionInvalidException;
import com.cts.portfolio.dailyshareprice.exception.StockNotFoundException;
import com.cts.portfolio.dailyshareprice.service.StockDetailsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/daily-share-price")
@Slf4j
public class StockDetailsController {
	@Autowired
	StockDetailsService stockDetailsService;

	@PostMapping("/get-stocks-price")
	public List<Double> getDailySharePriceByIdList(@RequestHeader("Authorization") String token,
			@RequestBody List<String> stockIdList) throws SessionInvalidException {
		/**
		 * @param token This is the first parameter for doing the authorisation of
		 *              method call.
		 * @Param stockIdList This is the second parameter which will take list of stock
		 *        Ids String Type.
		 * @return if token is valid, it will return the mutualFundIdList by calling
		 *         .getStockByIdList of service class. else, it will return null.
		 */

		log.info("Start");
		if (stockDetailsService.isSessionValid(token)) {
			return stockDetailsService.getStockbyIdList(stockIdList);
		}

		log.info("End");
		return new ArrayList<>();

	}

	@GetMapping("/daily-share-price/name/{stockName}")
	public StockDetailsDto getDailySharePrice(@RequestHeader("Authorization") String token,
			@PathVariable String stockName) throws StockNotFoundException, SessionInvalidException {
		/**
		 * @param token is the parameter for doing the authorisation of method call.
		 * @return if token is valid, then this method will return the details of Stock
		 *         which is given in GetMapping by calling the .getStockByName of
		 *         Service Class . else, it will return null.
		 */
		log.info("Start");
		if (stockDetailsService.isSessionValid(token)) {
			return stockDetailsService.getStockbyName(stockName);
		}
		log.info("End");
		return null;
	}

}
