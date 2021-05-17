package com.cts.portfolio.networth.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NetWorthExceptionTest {

	@Test
	void testStockNotFoundException() {
		NetWorthException netWorthException = new NetWorthException("networth issue");
		assertEquals("networth issue", netWorthException.getMessage());
	}
}
