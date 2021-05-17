package com.cts.portfolio.dailyshareprice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cts.portfolio.dailyshareprice.model.StockDetails;

class StockDetailsTest {

	StockDetails stockDetails=new StockDetails();
	@Test
	void testGetStockId() {
		stockDetails.setStockId("101");
		assertEquals("101", stockDetails.getStockId());
	}

	@Test
	void testGetStockName() {
		stockDetails.setStockName("abc");
		assertEquals("abc", stockDetails.getStockName());
	}

	@Test
	void testGetStockValue() {
		stockDetails.setStockValue(10.0);
		assertEquals(10.0, stockDetails.getStockValue());
	}
	
	@Test
	void testShareDetailsStringStringDouble() {
		StockDetails stockDetails=new StockDetails("101", "abc", 10.0);
		assertEquals("101", stockDetails.getStockId());
		assertEquals("abc", stockDetails.getStockName());
		assertEquals(10.0, stockDetails.getStockValue());
	}

	@Test
	void testShareDetails() {
		StockDetails stockDetails=new StockDetails();
		assertNotNull(stockDetails);
	}

	@Test
	void testToString() {
		StockDetails stockDetails=new StockDetails("101", "abc", 10.0);
		assertEquals("StockDetails(stockId=101, stockName=abc, stockValue=10.0)", stockDetails.toString());
		
	}

	

}
