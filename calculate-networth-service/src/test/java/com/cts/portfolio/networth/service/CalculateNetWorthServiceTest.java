package com.cts.portfolio.networth.service;

//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.portfolio.networth.model.AssetDetails;
import com.cts.portfolio.networth.repository.CalculateNetworthPortfolioRepository;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateNetWorthServiceTest {

	@Autowired
	CalculateNetworthPortfolioRepository calculateNetWorthPortfolioRepository;

	@Test
	void testFindByPortfolioIdAndAssetIdAndAssetType() {
		AssetDetails assetDetails = calculateNetWorthPortfolioRepository.findByPortfolioIdAndAssetIdAndAssetType(1001,
				"DEL", "1");
		assertNull(assetDetails);
	}

	@Test
	void testfindByPortfolioIdAndAssetId() {
		AssetDetails assetDetails = calculateNetWorthPortfolioRepository.findByPortfolioIdAndAssetId(2, "Hello");
		assertNull(assetDetails);
	}
	
	@Test
	 void testFindByPortfolioIdOrderByAssetId() {
		List<AssetDetails> list1 = calculateNetWorthPortfolioRepository.findAll();
		List<AssetDetails> list2 = calculateNetWorthPortfolioRepository.findAll();
		assertEquals(list1,list2);
	}
	
	
}
