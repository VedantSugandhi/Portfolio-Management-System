package com.cts.portfolio.webportal.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;

import com.cts.portfolio.webportal.model.AssetDetailsDto;
import com.cts.portfolio.webportal.model.AssetSellDetailsDto;
import com.cts.portfolio.webportal.model.UserDataDto;

public interface WebportalService {

	public String postLogin(UserDataDto user, HttpSession session, ModelMap warning);
	
	public String getHomePage(String token);
	
	public double sellShares(String token,AssetSellDetailsDto sellDetailsDto);
	
	public double getPortFolioNetworthFromCalculateNetworth(String token, int portfolioId);
	
	public List<AssetDetailsDto> getAllAssets(String token, int idInInt);
	
	public Boolean isSessionValid(String token);
	
}
