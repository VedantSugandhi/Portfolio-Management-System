package com.cts.portfolio.networth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AuthResponseTest {

	AuthResponse authResponse = new AuthResponse();

	@Test
	void testSetUid() {
		authResponse.setUserId("Ram");
		assertEquals("Ram", authResponse.getUserId());
	}

	@Test
	void testSetName() {
		authResponse.setUserName("name");
		assertEquals("name", authResponse.getUserName());
	}

	@Test
	void testSetValid() {
		authResponse.setValid(true);
		assertEquals(true, authResponse.isValid());
	}

}
