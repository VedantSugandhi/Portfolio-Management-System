package com.cts.portfolio.networth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class AssetSellDetailsTest {

	AssetSellDetails assetSellDetails = new AssetSellDetails();

	@Test
	void testSellObjectMapIntMapOfStringIntegerMapOfStringInteger() {
		AssetSellDetails sell = new AssetSellDetails(1, "Microsoft", 5);
		assertNotNull(sell);
		
	}

	@Test
	void testSetAssetId() {
		assetSellDetails.setAssetId("1234");
		assertEquals("1234", assetSellDetails.getAssetId());
	}

	@Test
	void testAssetCount() {
		assetSellDetails.setCount(6);
		assertEquals(6, assetSellDetails.getCount());
	}

	@Test
	void testIdEvaluation() {
		AssetSellDetails assetSellDetails = new AssetSellDetails();
		assertNotNull(assetSellDetails);
	}

	@Test
	void testToString() {
		AssetSellDetails sell = new AssetSellDetails(5, "MRF", 7);
		assertEquals("AssetSellDetails(id=5, assetId=MRF, count=7)", sell.toString());
	}

}
