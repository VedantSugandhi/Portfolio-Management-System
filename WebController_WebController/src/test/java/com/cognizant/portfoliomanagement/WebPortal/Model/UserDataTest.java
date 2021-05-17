package com.cognizant.portfoliomanagement.WebPortal.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cts.portfolio.webportal.model.UserDataDto;

class UserDataTest {
	
	UserDataDto userData=new UserDataDto();

	@Test
	void testSetUserid() {
		userData.setUserId("user1");
		assertEquals("user1", userData.getUserId());
	}

	@Test
	void testSetUserPassword() {
		userData.setUserPassword("pwd");
		assertEquals("pwd", userData.getUserPassword());
	}

	@Test
	void testSetUname() {
		userData.setUserName("user1");
		assertEquals("user1", userData.getUserName());
	}

	@Test
	void testSetAuthToken() {
		userData.setAuthToken("authToken");
		assertEquals("authToken", userData.getAuthToken());
	}

	@Test
	void testUserDataStringStringStringString() {
		UserDataDto user=new UserDataDto("101", "pwd", "101", "usertoken");
	}

	@Test
	void testUserData() {
		UserDataDto user1=new UserDataDto();
	}

}
