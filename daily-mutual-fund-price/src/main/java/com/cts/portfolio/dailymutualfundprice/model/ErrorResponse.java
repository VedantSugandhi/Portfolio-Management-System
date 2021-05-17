package com.cts.portfolio.dailymutualfundprice.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * This is a model class for Error response
 * @author POD-1
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private String path;

}
