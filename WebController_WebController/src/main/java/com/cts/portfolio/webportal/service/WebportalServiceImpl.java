package com.cts.portfolio.webportal.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;

import com.cts.portfolio.webportal.model.AssetDetailsDto;
import com.cts.portfolio.webportal.model.AssetSellDetailsDto;
import com.cts.portfolio.webportal.model.AuthResponse;
import com.cts.portfolio.webportal.model.UserDataDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WebportalServiceImpl implements WebportalService {
	
	@Autowired
	RestTemplate rt;
	
	public String postLogin(UserDataDto user, HttpSession session, ModelMap warning) {

		UserDataDto res = null;
		try {
			res = rt.postForObject("http://localhost:8100/login", user, UserDataDto.class);

		} catch (Exception e) {
			e.printStackTrace();
			String errmsg = "";
			if (e.getClass().toString().contains("feign.RetryableException"))
				errmsg = "Curently out of service. Please try again later.";
			else
				errmsg = "You have entered wrong login credentials. Please check and try again.";
			warning.addAttribute("errormsg", errmsg);
			return "login";
		}
		session.setAttribute("token", "Bearer " + res.getAuthToken());
		session.setAttribute("memberId", res.getUserId());
		return getHomePage((String) session.getAttribute("token"));
	}

	public String getHomePage(String token) {

		try {
			HttpHeaders header = new HttpHeaders();
			header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			header.set("Authorization", token);
			boolean isValidate = isSessionValid(token);
		} catch (Exception e) {
			return "redirect:/";
		}
		return "Home";

	}
	
	public double sellShares(String token,AssetSellDetailsDto sellDetailsDto) {
		log.info("SellSharesService method running");
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		header.set("Authorization", token);
		HttpEntity<AssetSellDetailsDto> httpEntity = new HttpEntity<>(sellDetailsDto,header);
		log.info("HttpEntity found");
		return rt.postForObject("http://localhost:8200/calculate-networth/sell-assets",httpEntity,
					Double.class);
		
	}
	
	public double getPortFolioNetworthFromCalculateNetworth(String token, int portfolioId) {
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		header.set("Authorization", token);
		HttpEntity<Integer> httpEntity = new HttpEntity<>(portfolioId,header);
		return  rt.postForObject("http://localhost:8200/calculate-networth/get-networth",httpEntity, Double.class);
		
	}

	@SuppressWarnings("unchecked")
	public List<AssetDetailsDto> getAllAssets(String token, int idInInt) {

		HttpHeaders header = new HttpHeaders();
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		header.set("Authorization", token);
		HttpEntity<Integer> httpEntity = new HttpEntity<>(idInInt,header);
		return (List<AssetDetailsDto>) rt.postForObject("http://localhost:8200/calculate-networth/get-all-assets", httpEntity,Collection.class);
	}

	public Boolean isSessionValid(String token) {
		try {
			
			HttpHeaders header = new HttpHeaders();
			header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			header.set("Authorization", token);
			HttpEntity<String> httpEntity = new HttpEntity<>(header);
			ResponseEntity<AuthResponse> authResponse  = rt.exchange("http://localhost:8100/validate", HttpMethod.GET,httpEntity,AuthResponse.class);
			
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
