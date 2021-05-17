package com.cognizant.portfoliomanagement.WebPortal.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cts.portfolio.webportal.model.AssetDetailsDto;

class AssetDetailsDtoTest {

	AssetDetailsDto asset = new AssetDetailsDto();

	@Test
	void testSetTId() {
		asset.setAssetId("1");
		assertEquals("1", asset.getAssetId());
	}

	@Test
	void testSetAssetId() {
		asset.setAssetId("101");
		assertEquals("101", asset.getAssetId());
	}

	@Test
	void testSetPortfolioId() {
		asset.setPortfolioId(11);
		assertEquals(11, asset.getPortfolioId());
	}

	@Test
	void testSetType() {
		asset.setAssetType("MF");
		assertEquals("MF", asset.getAssetType());
	}

	@Test
	void testSetCounts() {
		asset.setCount(10);
		assertEquals(10, asset.getCount());
	}

	@Test
	void testToString() {
		AssetDetailsDto asset1 = new AssetDetailsDto(1, "101", 11, "MRF", 10);
		assertEquals("AssetDetails(id=1, assetId=101, portfolioId=11, assetType=MRF, count=10)", asset1.toString());
	}

}
