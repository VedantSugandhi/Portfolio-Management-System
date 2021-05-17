package com.cts.portfolio.dailymutualfundprice.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MutualFundDetailsTest {

	MutualFundDetails mutualFundDetails = new MutualFundDetails();

	@Test
	void testGetMutualFundId() {
		mutualFundDetails.setMutualFundId("101");
		assertEquals("101", mutualFundDetails.getMutualFundId());
	}

	@Test
	void testGetMutualFundName() {
		mutualFundDetails.setMutualFundName("xyz");
		assertEquals("xyz", mutualFundDetails.getMutualFundName());
	}

	@Test
	void testGetMutualFundValue() {
		mutualFundDetails.setMutualFundValue(10.0);
		assertEquals(10.0, mutualFundDetails.getMutualFundValue());
	}

	@Test
	void testMutualFundDetailsStringDouble() {
		MutualFundDetails mutualFundDetails = new MutualFundDetails("101", "xyz", 55.0);
		assertEquals("101", mutualFundDetails.getMutualFundId());
		assertEquals("xyz", mutualFundDetails.getMutualFundName());
		assertEquals(55.0, mutualFundDetails.getMutualFundValue());
	}

	@Test
	void testShareDetails() {
		MutualFundDetails mutualFundDetails = new MutualFundDetails();
		assert (true);
	}

	@Test
	void testToString() {
		MutualFundDetails mutualFundDetails = new MutualFundDetails("101", "xyz", 55.0);
		assertEquals("MutualFundDetails(mutualFundId=101, mutualFundName=xyz, mutualFundValue=55.0)",
				mutualFundDetails.toString());

	}
}
