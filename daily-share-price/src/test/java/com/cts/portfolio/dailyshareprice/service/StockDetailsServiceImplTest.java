package com.cts.portfolio.dailyshareprice.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cts.portfolio.dailyshareprice.dto.StockDetailsDto;
import com.cts.portfolio.dailyshareprice.exception.SessionInvalidException;
import com.cts.portfolio.dailyshareprice.exception.StockNotFoundException;
import com.cts.portfolio.dailyshareprice.model.StockDetails;
import com.cts.portfolio.dailyshareprice.repository.StockDetailsRepository;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class StockDetailsServiceImplTest {

	@BeforeAll
	public static void beforeTestStart() {
		log.info("Testing Started . ");
	}

	@Autowired
	private StockDetailsRepository stockDetailsRepository;

	@MockBean
	private StockDetailsServiceImpl stockDetailsServiceImpl;

	@Test
	void testGetStockByName() throws StockNotFoundException {
		StockDetails item = stockDetailsRepository.findByStockName("Cognizant");
		boolean temp = item.getStockValue() == 2300.0 ? true : false;
		assertTrue(temp);
	}

	@Test
	void testGetStockByNameAndWrongId() throws StockNotFoundException {
		StockDetailsDto item = stockDetailsServiceImpl.getStockbyName("Hello World");
		assertNull(item);
	}

	@Test
	void testGetStockByNameAndWrongIdWithException() throws StockNotFoundException {
		when(stockDetailsServiceImpl.getStockbyName("Unknown")).thenThrow(StockNotFoundException.class);
		assertThrows(StockNotFoundException.class, () -> stockDetailsServiceImpl.getStockbyName("Unknown"));
	}

	@Test
	void testIsSessionValid() throws SessionInvalidException {
		String token = "portfolioId";
		when(stockDetailsServiceImpl.isSessionValid(token)).thenReturn(true);
		assertTrue(stockDetailsServiceImpl.isSessionValid(token));
	}

	@Test
	void testGetStockbyIdList() throws SessionInvalidException {
		String token = "portfolioId";
		when(stockDetailsServiceImpl.isSessionValid(token)).thenReturn(true);
		List<String> stockIdList = Arrays.asList("CCS", "CTS", "DEL");
		List<Double> stockRateList = stockDetailsServiceImpl.getStockbyIdList(stockIdList);
		assertNotNull(stockRateList);
	}

	@Test
	void testGetStockbyIdListTwo() throws SessionInvalidException {
		String token = "portfolioId";
		when(stockDetailsServiceImpl.isSessionValid(token)).thenReturn(true);
		List<String> stockIdList = Arrays.asList("hello", "World");
		List<Double> stockRateList = stockDetailsServiceImpl.getStockbyIdList(stockIdList);
		assertEquals(0, stockRateList.size());
	}
}