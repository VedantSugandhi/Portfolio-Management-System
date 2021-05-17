package com.cts.portfolio.dailyshareprice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * This is a model class for authenticated response
 * 
 * @author POD-1
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

	private String userId;
	private String userName;
	private boolean isValid;

}
