package com.cts.portfolio.dailyshareprice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()

public class SessionInvalidException extends Exception {

	private static final long serialVersionUID = 1L;

	public SessionInvalidException(String message) {
		/**
		 * It will give exception message of super class.
		 */
		super(message);
	}

}
