package com.cts.portfolio.networth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class AssetDetailsTest {

	AssetDetails asset = new AssetDetails();

	@Test
	void testSetTid() {
		asset.setAssetId("1");
		assertEquals("1", asset.getAssetId());
	}

	@Test
	void testSetAssetid() {
		asset.setAssetId("101");
		assertEquals("101", asset.getAssetId());
	}

	@Test
	void testSetPortfolioid() {
		asset.setPortfolioId(11);
		assertEquals(11, asset.getPortfolioId());
	}

	@Test
	void testSetType() {
		asset.setAssetType("CTS");
		assertEquals("CTS", asset.getAssetType());
	}

	@Test
	void testSetUnits() {
		asset.setCount(10);
		assertEquals(10, asset.getCount());
	}

	@Test
	void testAssetIntStringIntStringInt() {
		AssetDetails asset1 = new AssetDetails(1, "101", 11, "MF", 10);
		assertNotNull(asset1);
	}

	@Test
	void testAsset() {
		AssetDetails asset1 = new AssetDetails();
		assertNotNull(asset1);
	}

	@Test
	void testToString() {
		AssetDetails asset = new AssetDetails(1, "101", 11, "MF", 10);
		assertEquals("AssetDetails(id=1, assetId=101, portfolioId=11, assetType=MF, count=10)", asset.toString());
	}

}
