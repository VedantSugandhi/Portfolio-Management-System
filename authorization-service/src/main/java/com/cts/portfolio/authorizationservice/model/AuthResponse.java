package com.cts.portfolio.authorizationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * This is a model class for authenticated response 
 * @author POD-3
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

	private String userId;

	private String userName;

	private boolean isValid;
}
