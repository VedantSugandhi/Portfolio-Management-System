package com.cts.portfolio.dailyshareprice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.portfolio.dailyshareprice.dto.StockDetailsDto;
import com.cts.portfolio.dailyshareprice.exception.StockNotFoundException;
import com.cts.portfolio.dailyshareprice.model.StockDetails;
import com.cts.portfolio.dailyshareprice.repository.StockDetailsRepository;
import com.cts.portfolio.dailyshareprice.service.StockDetailsServiceImpl;

import lombok.extern.slf4j.Slf4j;

@AutoConfigureMockMvc
@Slf4j
@SpringBootTest
class DailySharePriceServiceTests {

	@BeforeAll
	public static void beforeTestStart() {
		log.info("Testing Started . ");
	}

	@Autowired
	private StockDetailsServiceImpl stockDetailsServiceImpl;
	
	@Autowired
	private StockDetailsRepository stockDetailsRepository;

	@Test
	public void testFindOne() throws StockNotFoundException {
		StockDetailsDto item = stockDetailsServiceImpl.getStockbyName("Cognizant");
		boolean temp = item.getStockValue() == 2300.0 ? true : false;
		assertTrue(temp);
	}

	@Test
	public void testFindTwo() {
		StockDetails item = stockDetailsRepository.findByStockName("Microsoft");
		boolean temp = item.getStockName() == "Microsoft" ? true : false;
		assertFalse(temp);
	}

}