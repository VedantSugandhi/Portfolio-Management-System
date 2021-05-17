package com.cts.portfolio.networth.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SellCountOverLimitExceptionTest {

	@Test
	void testStockNotFoundException() {
		SellCountOverLimitException sellCountOverLimitException = new SellCountOverLimitException(
				"sell count over limit");
		assertEquals("sell count over limit", sellCountOverLimitException.getMessage());
	}

}
