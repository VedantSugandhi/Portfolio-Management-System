package com.cts.portfolio.webportal.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Model class for the business details */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDataDto {

	/**
	 * Id for user
	 */

	private String userId;
	/**
	 * Password for user
	 */
	private String userPassword;
	/**
	 * Name for user
	 */
	private String userName;
	/**
	 * Generated authentication token for the user
	 */
	private String authToken;
}
