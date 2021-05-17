package com.cts.portfolio.networth.service;

import java.util.List;

import com.cts.portfolio.networth.dto.AssetDetailsDto;
import com.cts.portfolio.networth.dto.AssetSellDetailsDto;
import com.cts.portfolio.networth.exception.SellCountOverLimitException;

public interface CalculateNetworthService {

	public List<AssetDetailsDto> getAllAssetForPortfolio(int portfolioId);
	public boolean isSessionValid(String token);
	public void sellAsset(AssetSellDetailsDto assetSellDetailsDto) throws SellCountOverLimitException;
	public List<Double> findDailySharePriceById(String token, List<String> stockAssetList);
	public List<Double> findDailyMutualFundPriceById(String token, List<String> mutualFundAssetList);
	
}
