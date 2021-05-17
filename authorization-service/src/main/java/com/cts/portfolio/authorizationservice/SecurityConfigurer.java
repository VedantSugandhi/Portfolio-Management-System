package com.cts.portfolio.authorizationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.cts.portfolio.authorizationservice.service.AuthService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthService authService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.info("START configure auth");
		super.configure(auth);
		auth.userDetailsService(authService);
		log.info("END configure auth");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("START configure security");

		http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and()
				.exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		log.info("END security");

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		log.info("START configure websecurity");

		web.ignoring().antMatchers("/authapp/login", "/h2-console/**", "/v2/api-docs", "/configuration/ui",
				"/configuration/security", "/webjars/**");
		log.info("END configure websecurity");

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		log.info("START AuthenticationManager");
		log.info("END AuthenticationManager");
		return super.authenticationManagerBean();
	}

}
