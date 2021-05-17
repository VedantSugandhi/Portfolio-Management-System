package com.cts.portfolio.dailyshareprice.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class ErrorResponseTest {
	
	ErrorResponse errorResponse=new ErrorResponse();

	@Test
	void testErrorResponseDateStringString() {
		ErrorResponse errorResponse=new ErrorResponse(new  Date("21/3/2021"),404, "error", "error occured","http://daily-share-price/");
		assertNotNull(errorResponse);
	}

	@Test
	void testGetTimeStamp() {
		errorResponse.setTimestamp(new Date(2021, 3, 21));
		assertEquals(new Date(2021, 3, 21),errorResponse.getTimestamp());
	}

	@Test
	void testErrorResponse() {
		ErrorResponse ex=new ErrorResponse();
		assertNotNull(ex);
	}

	@Test
	void testGetMessage() {
		errorResponse.setMessage("Error occured");
		assertEquals("Error occured",errorResponse.getMessage());
	}

	@Test
	void testToString() {
		assertEquals("ErrorResponse(timestamp=null, status=0, error=null, message=null, path=null)",errorResponse.toString());
	}

}
