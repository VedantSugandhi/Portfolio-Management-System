package com.cts.portfolio.authorizationservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name = "user_data")
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "user_name")
	private String userName;

	private String authToken;



}
