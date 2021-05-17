package com.cts.portfolio.dailyshareprice;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cts.portfolio.dailyshareprice.controller.StockDetailsController;


@AutoConfigureMockMvc
@SpringBootTest
class DailySharePriceApplicationTests {

	@Autowired
	private StockDetailsController stockDetailsController;

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
		assertNotNull(stockDetailsController);
	}

	@Test
	void testGetDailySharePrice() throws Exception {

		ResultActions actions = mvc.perform(get("/daily-share-price/name/Cisco"));
		actions.andExpect(status().isNotFound());
	}

	@Test
	void testGetAllDailySharePrice() throws Exception {

		ResultActions actions = mvc.perform(get("/daily-all-share-price"));
		actions.andExpect(status().isNotFound());

	}

	@Test
	void testGetDailySharePriceByIDList() throws Exception {

		ResultActions actions = mvc.perform(get("/daily-share-price/CCS"));
		actions.andExpect(status().isNotFound());

	}
}
