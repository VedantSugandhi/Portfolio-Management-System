package com.cts.portfolio.dailymutualfundprice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.portfolio.dailymutualfundprice.exception.MutualFundNotFoundException;
import com.cts.portfolio.dailymutualfundprice.model.MutualFundDetails;
import com.cts.portfolio.dailymutualfundprice.repository.MutualFundDetailsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class MutualFundDetailsServiceImplTest {

	@MockBean
	private MutualFundDetailsServiceImpl mutualFundDetailsServiceImpl;

	@Autowired
	private MutualFundDetailsRepository mutualFundDetailsRepository;

	@Test
	public void testFindMutualFund() throws MutualFundNotFoundException {
		MutualFundDetails item = mutualFundDetailsRepository.findByMutualFundName("SBI");
		boolean temp = item.getMutualFundValue() == 3500.0 ? true : false;
		assertTrue(temp);
	}

	@Test
	public void testFindMutualFundTwo() throws MutualFundNotFoundException {
		MutualFundDetails item = mutualFundDetailsRepository.findByMutualFundName("IC");
		assertNull(item);
	}

	@Test
	void testGetMutualFundByNameAndWrongIdWithException() throws MutualFundNotFoundException {
		when(mutualFundDetailsServiceImpl.getMutualFundByName("Unknown")).thenThrow(MutualFundNotFoundException.class);
		assertThrows(MutualFundNotFoundException.class,
				() -> mutualFundDetailsServiceImpl.getMutualFundByName("Unknown"));
	}

	@Test
	void testIsSessionValid() {
		String token = "portfolioId";
		when(mutualFundDetailsServiceImpl.isSessionValid(token)).thenReturn(true);
		assertTrue(mutualFundDetailsServiceImpl.isSessionValid(token));
	}

	@Test
	void testGetMutualFundByNameAndId() {
		String token = "portfolioId";
		when(mutualFundDetailsServiceImpl.isSessionValid(token)).thenReturn(true);
		List<String> mutualFundList = Arrays.asList("ICICI", "AXIS");
		List<Double> mutualFundRateList = (mutualFundDetailsServiceImpl.getMutualFundPriceByIdList(mutualFundList));
		assertNotNull(mutualFundRateList);
	}

	@Test
	void testGetMutualFundByNameAndWrongId() {
		String token = "portfolioId";
		when(mutualFundDetailsServiceImpl.isSessionValid(token)).thenReturn(true);
		List<String> mutualFundList = Arrays.asList("hello", "World");
		List<Double> mutualFundRateList = (mutualFundDetailsServiceImpl.getMutualFundPriceByIdList(mutualFundList));
		assertEquals(0, mutualFundRateList.size());
	}

}