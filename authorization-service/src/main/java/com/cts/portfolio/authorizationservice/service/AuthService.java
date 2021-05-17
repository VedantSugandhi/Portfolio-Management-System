package com.cts.portfolio.authorizationservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.portfolio.authorizationservice.model.UserData;
import com.cts.portfolio.authorizationservice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class AuthService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
/**
 * Get UserData using JpaRepository, to get data by username,
 * throw exceptions if user not found
 */
	@Override
	public UserDetails loadUserByUsername(String userId) {
		log.info("START");
		try {
		
			UserData user = userRepository.getOne(userId);			
			if (user != null) {
				user.getUserName();
				log.info("END - User found");
				return new User(user.getUserId(),user.getUserPassword(),new ArrayList<>());
			} else {
				log.info("END - UsernameNotFound");
				throw new UsernameNotFoundException("UsernameNotFoundException");
			}
		} catch (Exception e) {
			log.info("EXCEPTION - UsernameNotFoundException");
			throw new UsernameNotFoundException("UsernameNotFoundException");
		}

	}

}
