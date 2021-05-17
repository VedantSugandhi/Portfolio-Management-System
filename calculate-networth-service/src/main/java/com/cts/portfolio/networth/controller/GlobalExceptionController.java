package com.cts.portfolio.networth.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.portfolio.networth.exception.SellCountOverLimitException;
import com.cts.portfolio.networth.model.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionController {
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ SellCountOverLimitException.class })
	public ErrorResponse handleOverLimitError(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(new Date(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				ex.getMessage(), request.getRequestURI());
	}
}
