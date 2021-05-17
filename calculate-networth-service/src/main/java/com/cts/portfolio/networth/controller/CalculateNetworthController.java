package com.cts.portfolio.networth.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.portfolio.networth.exception.SellCountOverLimitException;
import com.cts.portfolio.networth.dto.AssetDetailsDto;
import com.cts.portfolio.networth.dto.AssetSellDetailsDto;
import com.cts.portfolio.networth.service.CalculateNetworthService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/calculate-networth")
@Slf4j
public class CalculateNetworthController {
	@Autowired
	CalculateNetworthService networthService;

	@PostMapping("/get-networth")
	public double getNetworth(@RequestHeader("Authorization") String token, @RequestBody int portfolioId) {
		log.info("Starting getPortfolioNetworth");
		var netWorth = 0.0;
		if (networthService.isSessionValid(token)) {
			List<String> stockAssetList = new ArrayList<>();
			List<String> mutualFundAssetList = new ArrayList<>();
			List<Double> stockValueList = new ArrayList<>();
			List<Double> mutualFundValueList = new ArrayList<>();
			List<AssetDetailsDto> assetsList = networthService.getAllAssetForPortfolio(portfolioId);
			for (AssetDetailsDto asset : assetsList) {
				if (asset.getAssetType().equals("Stock")) {
					stockAssetList.add(asset.getAssetId());
				} else {
					mutualFundAssetList.add(asset.getAssetId());
				}
			}

			if (!stockAssetList.isEmpty()) {
				stockValueList = networthService.findDailySharePriceById(token, stockAssetList);
				log.info("found stock Value List");
			}
			if (!mutualFundAssetList.isEmpty()) {
				mutualFundValueList = networthService.findDailyMutualFundPriceById(token, mutualFundAssetList);
				log.info("found mutual Value List");
			}
			var stockCounter = 0;
			var mutualFundCounter = 0;
			for (AssetDetailsDto asset : assetsList) {
				if (asset.getAssetType().equals("Stock")) {
					netWorth += asset.getCount() * stockValueList.get(stockCounter);
					stockCounter++;
				} else {
					netWorth += asset.getCount() * mutualFundValueList.get(mutualFundCounter);
					mutualFundCounter++;
				}
			}
		}
		log.info("Ending getPortfolioNetworth");

		return netWorth;

	}

	@PostMapping("/get-all-assets")
	public List<AssetDetailsDto> getAllAssets(@RequestHeader("Authorization") String token,
			@RequestBody int portfolioId) {
		log.info("Starting getAllAssets");
		if (networthService.isSessionValid(token)) {
			log.info("Ending getAllAssets");
			return networthService.getAllAssetForPortfolio(portfolioId);
		}
		log.info("Ending getAllAssets");
		return new ArrayList<>();
	}

	@PostMapping("/sell-assets")
	public double sellPortfolioAssets(@RequestHeader("Authorization") String token,
			@RequestBody AssetSellDetailsDto assetSellDetailsDto) throws SellCountOverLimitException {
		log.info("Starting sellPortfolioAssets");
		if (networthService.isSessionValid(token)) {
			networthService.sellAsset(assetSellDetailsDto);
			double networth = getNetworth(token, assetSellDetailsDto.getId());
			log.info("Ending sellPortfolioAssets");
			return networth;

		}
		return 0.0;

	}
}
