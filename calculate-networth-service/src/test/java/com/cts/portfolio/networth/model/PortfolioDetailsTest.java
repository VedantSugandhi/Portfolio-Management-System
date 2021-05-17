package com.cts.portfolio.networth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class PortfolioDetailsTest {

	@Test
	void testPortfolio() {
		PortfolioDetails portfolio = new PortfolioDetails();
		assertNotNull(portfolio);
	}

	@Test
	void testPortfolioInt() {
		PortfolioDetails portfolio = new PortfolioDetails(1);
		assertNotNull(portfolio);
	}

	@Test
	void testToString() {
		PortfolioDetails portfolio = new PortfolioDetails(1);
		assertEquals("PortfolioDetails(portfolioId=1)", portfolio.toString());
	}

	@Test
	void testSetPortfolioId() {
		PortfolioDetails portfolio = new PortfolioDetails();
		portfolio.setPortfolioId(1);
		assertEquals(1, portfolio.getPortfolioId());
	}

}
