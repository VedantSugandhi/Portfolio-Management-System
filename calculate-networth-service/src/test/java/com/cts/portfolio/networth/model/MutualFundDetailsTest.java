package com.cts.portfolio.networth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class MutualFundDetailsTest {

	MutualFundDetailsDto mutualFund = new MutualFundDetailsDto();

	@Test
	void testSetMutualFundId() {
		mutualFund.setMutualFundId("101");
		assertEquals("101", mutualFund.getMutualFundId());
	}

	@Test
	void testSetMutualFundName() {
		mutualFund.setMutualFundName("abc");
		assertEquals("abc", mutualFund.getMutualFundName());
	}

	@Test
	void testSetMutualFundValue() {
		mutualFund.setMutualFundValue(10);
		assertEquals(10, mutualFund.getMutualFundValue());
	}

	@Test
	void testMutualFundDetailsStringStringDouble() {
		MutualFundDetailsDto mfd = new MutualFundDetailsDto("101", "AXIS", 10);
		assertNotNull(mfd);
	}

	@Test
	void testMutualFundDetails() {
		MutualFundDetailsDto mfd = new MutualFundDetailsDto();
		assertNotNull(mfd);
	}

	@Test
	void testToString() {
		MutualFundDetailsDto mfd = new MutualFundDetailsDto("101", "AXIS", 10);
		assertEquals("MutualFundDetailsDto(mutualFundId=101, mutualFundName=AXIS, mutualFundValue=10)", mfd.toString());
	}

}
