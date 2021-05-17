package com.cts.portfolio.authorizationservice.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JwtUtil {
/**
 * creating a secret key for token, can be changed to anything
 */
	private String secretkey = "${jwt.secret}";

	/**
	 * This method is used to extract the username from the token
	 * 
	 * @param token in the string format
	 * @return
	 */
	public String extractUsername(String token) {
		log.info("START extractUsername");
		log.info("END extractUsername");

		return extractClaim(token, Claims::getSubject);

	}

	/**
	 * This method is used to extract a particular claim for the token
	 * 
	 * @param <T>
	 * @param token
	 * @param claimsResolver
	 * @return
	 */
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		log.info("START extractClaim");

		final Claims claims = extractAllClaims(token);
		log.info("END extractClaim");

		return claimsResolver.apply(claims);

	}

	/**
	 * This method is used to extract claims for the token
	 * 
	 * @param token
	 * @return
	 */
	private Claims extractAllClaims(String token) {
		log.info("START extractAllClaims");
		log.info("END extractAllClaims");

		return Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();

	}


	public String generateToken(UserDetails userDetails) {
		log.info("START generateToken");

		Map<String, Object> claims = new HashMap<>();
		log.info("END generateToken");

		return createToken(claims, userDetails.getUsername());
	}

	/**
	 * This method is used to create token based on the claims and subject given as
	 * parameter. It will add a signature to the jwt token based on the algorithm
	 * HS256.
	 * 
	 * @param claims
	 * @param subject
	 * @return
	 */
	private String createToken(Map<String, Object> claims, String subject) {
		log.info("START createToken");

		String compact = Jwts.builder().setClaims(claims).setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + (1000*60*15)))
				.signWith(SignatureAlgorithm.HS256, secretkey).compact();
		log.info("END createToken");

		return compact;
	}

	/**
	 * This method is used to validate token based on the given token and
	 * userDetails as parameter. First from the token we will extract the username
	 * and then will check in the database whether the token extracted username and
	 * the user residing in database is same or not and also will check whether the
	 * token has been expired or not
	 * 
	 * @param token
	 * @param userDetails
	 * @return
	 */
	public Boolean validateToken(String token) {
		log.info("START validateToken");

		try {
			Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();
			log.info("ENDvalidateToken");

			return true;
		} catch (Exception e) {
			log.info("End validateToken EXCEPTION");
			return false;
		}

	}
}