package com.cts.portfolio.networth;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cts.portfolio.networth.controller.CalculateNetworthController;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateNetworthMicroserviceApplicationTests {

	@Autowired
	private CalculateNetworthController calculateNetworthController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertNotNull(calculateNetworthController);
	}

	@Test
	void testCalculateNetworthGetNetworth() throws Exception {
		ResultActions actions = mockMvc.perform(get("/calculate-networth/get-networth"));
		actions.andExpect(status().isMethodNotAllowed());

	}

	@Test
	void testCalculateNetworthGetAllAssets() throws Exception {
		ResultActions actions = mockMvc.perform(get("/calculate-networth/getAllAsset"));
		actions.andExpect(status().isNotFound());
	}

	@Test
	void testCalculateNetworthSellAssets() throws Exception {
		ResultActions actions = mockMvc.perform(get("/calculate-networth/sell-asset"));
		actions.andExpect(status().isNotFound());
	}

}
