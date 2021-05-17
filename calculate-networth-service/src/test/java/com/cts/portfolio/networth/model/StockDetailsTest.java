package com.cts.portfolio.networth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class StockDetailsTest {

	StockDetailsDto stockDetails = new StockDetailsDto();

	@Test
	void testGetShareId() {
		stockDetails.setStockId("101");
		assertEquals("101", stockDetails.getStockId());
	}

	@Test
	void testGetShareName() {
		stockDetails.setStockName("abc");
		assertEquals("abc", stockDetails.getStockName());
	}

	@Test
	void testGetShareValue() {
		stockDetails.setStockValue(10.0);
		assertEquals(10.0, stockDetails.getStockValue());
	}

	@Test
	void testStockDetailsStringStringDouble() {
		StockDetailsDto shareDetails = new StockDetailsDto("101", "abc", 10.0);
		assertEquals("101", shareDetails.getStockId());
		assertEquals("abc", shareDetails.getStockName());
		assertEquals(10.0, shareDetails.getStockValue());
	}

	@Test
	void testStockDetails() {
		StockDetailsDto stockDetails = new StockDetailsDto();
		assertNotNull(stockDetails);
	}

	@Test
	void testToString() {
		StockDetailsDto stockDetails = new StockDetailsDto("101", "abc", 10.0);
		assertEquals("StockDetailsDto(stockId=101, stockName=abc, stockValue=10.0)", stockDetails.toString());

	}

}
