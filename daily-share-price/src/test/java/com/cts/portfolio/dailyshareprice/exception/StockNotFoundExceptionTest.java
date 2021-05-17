package com.cts.portfolio.dailyshareprice.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StockNotFoundExceptionTest {

	@Test
	void testStockNotFoundException() {
		StockNotFoundException stockNotFoundException=new StockNotFoundException("Error occured");
		assertEquals("Error occured",stockNotFoundException.getMessage());
	}

}
