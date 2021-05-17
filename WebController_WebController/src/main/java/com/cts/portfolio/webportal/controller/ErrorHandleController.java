package com.cts.portfolio.webportal.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice

public class ErrorHandleController implements ErrorController {

	@GetMapping("/error")
	@ExceptionHandler(HttpClientErrorException.class)
	public ModelAndView handleError(HttpClientErrorException ex){
		ModelAndView errorPage = new ModelAndView("error");
		int code = ex.getRawStatusCode();
        String errorMsg="";
        
//        int httpErrorCode = getErrorCode(httpRequest);
        
        
        switch (code) {
            case 400: {
                errorMsg = "The selling quantity cannot exceed the available quantity of assets. Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Http Error Code: 401. Unauthorized";
                break;
            }
            case 404: {
                errorMsg = "Http Error Code: 404. Resource not found";
                break;
            }
            case 500: {
                errorMsg = "Http Error Code: 500. Internal Server Error";
                break;
            }
            default:{
            	errorMsg = "Kindly make a valid request. Please try again.";
            }
        }

        errorPage.addObject("errorMsg", errorMsg);
        errorPage.addObject("code", code);
		return errorPage;
	}


	@Override
	public String getErrorPath() {
		return "error";
	}

	
}
