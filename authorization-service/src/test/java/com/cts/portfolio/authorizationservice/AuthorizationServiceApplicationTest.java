package com.cts.portfolio.authorizationservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cts.portfolio.authorizationservice.controller.AuthController;
import com.cts.portfolio.authorizationservice.model.UserData;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class AuthorizationServiceApplicationTest {

	@Test
	void test() {
		assertTrue(true);
	}

	private static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxNTcyMTkxMywiaWF0IjoxNjE1NTQxOTEzfQ.sBh1dxvrhBUQWtmOIzJ0HYBIQCxZ__5Hhr1IvsOyYNI";
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AuthController authController;

	@Test
	void contextLoads() {
		assertNotNull(authController);
	}

	@Test
	void loginTestSuccess() throws Exception {
		UserData admin = new UserData("admin", "admin", "admin", token);

		ResultActions actions = mockMvc
				.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(asJsonString(admin)));
		actions.andExpect(status().isForbidden());
	}

	@Test
	void loginTestFail() throws Exception {
		UserData admin = new UserData("randomUser", "randomUser", "randomUser", token);

		ResultActions actions = mockMvc
				.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(asJsonString(admin)));
		actions.andExpect(status().isForbidden());
		actions.andExpect(status().reason("Access Denied"));
	}

	@Test
	void validateTestSuccess() throws Exception {
		ResultActions actions = mockMvc.perform(get("/validate").header("Authorization", token));

		actions.andExpect(status().isForbidden());

	}

	@Test
	void validateTestFail() throws Exception {
		ResultActions actions = mockMvc.perform(get("/validate").header("Authorization", "randomToken"));
		actions.andExpect(status().isForbidden());
	}

	public static String asJsonString(UserData admin) throws Exception {

		return new ObjectMapper().writeValueAsString(admin);

	}

}
