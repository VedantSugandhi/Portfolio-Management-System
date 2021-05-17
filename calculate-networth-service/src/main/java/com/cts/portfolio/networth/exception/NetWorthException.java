package com.cts.portfolio.networth.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NetWorthException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NetWorthException(String message) {
		
		super(message);
	}

}
