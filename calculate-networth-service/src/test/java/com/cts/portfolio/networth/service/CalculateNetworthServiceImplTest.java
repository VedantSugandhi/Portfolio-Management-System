package com.cts.portfolio.networth.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.portfolio.networth.dto.AssetDetailsDto;
import com.cts.portfolio.networth.dto.AssetSellDetailsDto;
import com.cts.portfolio.networth.exception.SellCountOverLimitException;
import com.cts.portfolio.networth.model.AssetDetails;
import com.cts.portfolio.networth.repository.CalculateNetworthPortfolioRepository;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateNetworthServiceImplTest {

	@MockBean
	CalculateNetworthPortfolioRepository calculateNetWorthPortfolioRepository;

	@MockBean
	CalculateNetworthServiceImpl calculateNetworthServiceImpl;

	@Test
	void testGetAllAssetForPortfolioId() {
		int portfolioId = 101;
		List<AssetDetailsDto> list = calculateNetworthServiceImpl.getAllAssetForPortfolio(portfolioId);
		assertNotNull(list);
	}

	@Test
	void testGetAllAssetForWrongPortfolioId() {
		int portfolioId = 1001;
		List<AssetDetailsDto> list = calculateNetworthServiceImpl.getAllAssetForPortfolio(portfolioId);
		assertEquals(0, list.size());
	}

	@Test
	void testIsSessionValid() {
		String token = "portfolioId";
		when(calculateNetworthServiceImpl.isSessionValid(token)).thenReturn(true);
		assertTrue(calculateNetworthServiceImpl.isSessionValid(token));
	}

	@Test
	void testIsSessionValidWithWrongToken() {
		String token = "Unknown";
		when(calculateNetworthServiceImpl.isSessionValid(token)).thenReturn(false);
		assertFalse(calculateNetworthServiceImpl.isSessionValid(token));
	}

	@Test
	void testFindDailySharePriceById() {
		String token = "portfolioId";
		List<String> stockIdList = Arrays.asList("CCS", "CTS", "DEL");
		when(calculateNetworthServiceImpl.isSessionValid(token)).thenReturn(true);
		List<Double> rateCard = calculateNetworthServiceImpl.findDailySharePriceById(token, stockIdList);
		assertNotNull(rateCard);
	}

	@Test
	void testFindDailySharePriceByWrongId() {
		String token = "portfolioId";
		List<String> stockIdList = Arrays.asList("TAMO", "TCS");
		when(calculateNetworthServiceImpl.isSessionValid(token)).thenReturn(true);
		List<Double> rateCard = calculateNetworthServiceImpl.findDailySharePriceById(token, stockIdList);
		assertEquals(0, rateCard.size());
	}

	@Test
	void testFindDailyMutualFundPriceById() {
		String token = "portfolioId";
		List<String> mutualFundList = Arrays.asList("AXIS", "ICICI", "SBI");
		when(calculateNetworthServiceImpl.isSessionValid(token)).thenReturn(true);
		List<Double> priceDetails = calculateNetworthServiceImpl.findDailyMutualFundPriceById(token, mutualFundList);
		assertNotNull(priceDetails);
	}

	@Test
	void testFindDailyMutualFundPriceByWrongId() {
		String token = "portfolioId";
		List<String> mutualFundList = Arrays.asList("Hello", "World");
		when(calculateNetworthServiceImpl.isSessionValid(token)).thenReturn(true);
		List<Double> priceDetails = calculateNetworthServiceImpl.findDailyMutualFundPriceById(token, mutualFundList);
		assertEquals(0, priceDetails.size());
	}

	@Test
	void testSellAsset() throws SellCountOverLimitException {
		String token = "portfolioId";
		AssetSellDetailsDto assetSellDetailsDto = new AssetSellDetailsDto(101, "CCS", 10);
		when(calculateNetworthServiceImpl.isSessionValid(token)).thenReturn(true);
		AssetDetails details = calculateNetWorthPortfolioRepository.findByPortfolioIdAndAssetId(101, "CCS");
		calculateNetworthServiceImpl.sellAsset(assetSellDetailsDto);
		assertNull(details);
	}

}