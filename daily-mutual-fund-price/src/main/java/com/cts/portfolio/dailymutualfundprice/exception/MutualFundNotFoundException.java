package com.cts.portfolio.dailymutualfundprice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MutualFundNotFoundException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public MutualFundNotFoundException(String message) {
		/**
		 * It will give exception message of super class.
		 */
		super(message);
	}

}
