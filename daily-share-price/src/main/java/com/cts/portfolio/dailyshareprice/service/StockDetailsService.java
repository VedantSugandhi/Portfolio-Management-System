package com.cts.portfolio.dailyshareprice.service;

import java.util.List;

import com.cts.portfolio.dailyshareprice.dto.StockDetailsDto;
import com.cts.portfolio.dailyshareprice.exception.SessionInvalidException;
import com.cts.portfolio.dailyshareprice.exception.StockNotFoundException;

/**
 * This is a service interface of Stock.
 */
public interface StockDetailsService {

	public List<Double> getStockbyIdList(List<String> stockId);

	public StockDetailsDto getStockbyName(String stockName) throws StockNotFoundException;

	public boolean isSessionValid(String token) throws SessionInvalidException;
}
