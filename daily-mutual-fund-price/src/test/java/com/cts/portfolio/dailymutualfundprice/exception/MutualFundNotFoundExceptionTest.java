package com.cts.portfolio.dailymutualfundprice.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MutualFundNotFoundExceptionTest {

	@Test
	void testMutualFundNotFoundExceptionTest() {
		MutualFundNotFoundException mutualFundNotFoundException=new MutualFundNotFoundException("Error occured");
		assertEquals("Error occured",mutualFundNotFoundException.getMessage());
	}

}
