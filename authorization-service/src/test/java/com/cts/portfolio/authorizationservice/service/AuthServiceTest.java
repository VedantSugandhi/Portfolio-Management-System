package com.cts.portfolio.authorizationservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.cts.portfolio.authorizationservice.model.UserData;

class AuthServiceTest {

	@Mock
	AuthService service;
	UserData user;
	
	@BeforeEach
	public void init() {
		UserData user = new UserData();
	}
	
	@Test
	void testloadUserByUsername() {
		
//		when(service.loadUserByUsername("101")).thenReturn("101");
		
	}

}