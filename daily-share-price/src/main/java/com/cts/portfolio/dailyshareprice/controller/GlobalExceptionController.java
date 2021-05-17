package com.cts.portfolio.dailyshareprice.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.portfolio.dailyshareprice.exception.StockNotFoundException;
import com.cts.portfolio.dailyshareprice.model.ErrorResponse;

/**
 * @ControllerAdvice is a annotation provided by Spring allowing you to write
 *                   global code that can be applied to a wide range of
 *                   controllers, varying from all controllers to a chosen
 *                   package or even a specific annotation.
 */

@RestControllerAdvice
public class GlobalExceptionController {
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler({ StockNotFoundException.class })
	public ErrorResponse handleNotFoundError(Exception ex, HttpServletRequest request) {
		/**
		 * @param ex is the first parameter of type Exception
		 * @Param request is the second parameter of type HttpServletRequest
		 * @return object of class ErrorResponse.
		 * 
		 */
		return new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(),
				ex.getMessage(), request.getRequestURI());
	}
}
