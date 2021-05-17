package com.cts.portfolio.networth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SellCountOverLimitException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SellCountOverLimitException(String message) {
		super(message);
	}
	

}
