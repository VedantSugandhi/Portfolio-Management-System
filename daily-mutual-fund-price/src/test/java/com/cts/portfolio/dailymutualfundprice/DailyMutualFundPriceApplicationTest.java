package com.cts.portfolio.dailymutualfundprice;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cts.portfolio.dailymutualfundprice.controller.MutualFundDetailsController;

import lombok.extern.slf4j.Slf4j;

@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
class DailyMutualFundPriceApplicationTest {

	@Autowired
	private MutualFundDetailsController mutualFundDetailsController;

	@Autowired
	private MockMvc mvc;

	@BeforeEach
	public void beforeTestStart() {
		log.info("Testing Started . ");
	}

	@Test
	void contextLoads() {
		assertNotNull(mutualFundDetailsController);
	}

//	@Test
//	void testGetDailyMutualFundPrice() throws Exception {
//		ResultActions actions = mvc.perform(get("/daily-mutual-fund-price/name/UTI"));
//		actions.andExpect(status().isNotFound());
//	}
//
//	@Test
//	void testGetAllDailyMutualFundPrice() throws Exception {
//		ResultActions actions = mvc.perform(get("/daily-all-mutual-fund-price"));
//		actions.andExpect(status().isNotFound());
//
//	}

	@Test
	void testGetDailyMutualFundPriceByIDList() throws Exception {
		ResultActions actions = mvc.perform(get("/daily-mutual-fund-price/SBI"));
		actions.andExpect(status().isNotFound());

	}

}
