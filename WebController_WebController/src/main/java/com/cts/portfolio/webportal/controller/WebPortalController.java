package com.cts.portfolio.webportal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.portfolio.webportal.model.AssetDetailsDto;
import com.cts.portfolio.webportal.model.AssetSellDetailsDto;
import com.cts.portfolio.webportal.model.UserDataDto;
import com.cts.portfolio.webportal.service.WebportalService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WebPortalController {

	@Autowired
	UserDataDto user;

	@Autowired
	AssetSellDetailsDto sellDetailsDto;

	private static List<String> revokedTokens = new ArrayList<>();

	@Autowired
	WebportalService webPortalService;
	
	ModelAndView loginView = new ModelAndView("login");

	@GetMapping("/logout")
	public ModelAndView getLogout(HttpSession session) {

		/*
		 * This method is responsible for the logout functionality
		 * 
		 */
		
		String token = (String) session.getAttribute("token");
		boolean isValid = webPortalService.isSessionValid(token);
		log.info("Starting logout");
		
		if (session != null && token != null
				&& isValid) {
			
			revokedTokens.add(token);
			log.info("ending logout");
			return loginView;
		}
		
		log.info("ending logout");
		return new ModelAndView("Home");
	}

	@GetMapping("/")
	public ModelAndView getLogin(HttpSession session) {

		/*
		 * This method will evaluate the login credentials by calling the authorization
		 * service and if they are valid then it will redirect to the home else it will
		 * redirect the user to the login page.
		 * 
		 */

		log.info("Starting getLogin");

		boolean isValid = webPortalService.isSessionValid((String) session.getAttribute("token"));
		if (session != null && (String) session.getAttribute("token") != null
				&& isValid
				&& !revokedTokens.contains(session.getAttribute("token"))) {
			
			log.info("Ending getLogin");
			return new ModelAndView("Home");
		}
		
		log.info("Ending getLogin");
		return loginView;
	}

	@PostMapping("/login")
	public ModelAndView postLogin(HttpSession session, ModelMap model, @ModelAttribute UserDataDto user,
			ModelMap warning) {
		
		log.info("Starting postLogin");
		log.info("Ending postLogin");
		return new ModelAndView(webPortalService.postLogin(user, session, warning));
	}

	@GetMapping("/home")
	public ModelAndView getHomePage(HttpSession session) {
		log.info("Starting getHomePage");
		boolean isValid = webPortalService.isSessionValid((String) session.getAttribute("token"));
		if (isValid && !revokedTokens.contains(session.getAttribute("token"))) {
			
			log.info("Ending getHomePage");
			return new ModelAndView("Home");
		}
		
		log.info("Ending getHomePage");
		return loginView;
	}

	@GetMapping("/calculate-networth")
	public ModelAndView showNetworth(HttpSession session, ModelMap model) {
		
		log.info("Starting viewNetworth");
		boolean isValid = webPortalService.isSessionValid((String) session.getAttribute("token"));
		if (isValid && !revokedTokens.contains(session.getAttribute("token"))) {

			String s = (String) session.getAttribute("memberId");
			int id = Integer.parseInt(s);
			String token = (String) session.getAttribute("token");
			model.put("networth", webPortalService.getPortFolioNetworthFromCalculateNetworth(token, id));
			log.info("Ending viewNetworth");
			return new ModelAndView("viewNetworth");
		}
		
		log.info("Ending viewNetworth");
		return loginView;
	}

	@GetMapping("/sell-assets")
	public ModelAndView showSupplyPage(HttpSession session, ModelMap model) {
		
		log.info("Starting showSellAssets");
		boolean isValid = webPortalService.isSessionValid((String) session.getAttribute("token"));
		if (isValid && !revokedTokens.contains(session.getAttribute("token"))) {
			
			log.info("Ending showSellAssets");
			String idInString = (String) session.getAttribute("memberId");
			int idInInt = Integer.parseInt(idInString);
			String token = (String) session.getAttribute("token");
			List<AssetDetailsDto> asset = webPortalService.getAllAssets(token, idInInt);
			
			if (asset.isEmpty()) {
				return new ModelAndView("NoAssetFound");
			}
			
			log.info("Asset Details List:" + asset);
			model.put("asset", asset);
			return new ModelAndView("sellAssets");
		}
		
		log.info("Ending showSellAssets");
		return loginView;
	}

	@PostMapping(path = "/sell-asset")
	public ModelAndView toSellAnAsset(HttpSession session, @RequestParam("assetId") String assetId,
			@RequestParam("count") int count, ModelMap model) {

		log.info("Starting toSellAnAssetController");
		String idInString = (String) session.getAttribute("memberId");
		int idInInt = Integer.parseInt(idInString);
		log.info("found id in Int");
		String token = (String) session.getAttribute("token");
		sellDetailsDto.setAssetId(assetId);
		sellDetailsDto.setId(idInInt);
		sellDetailsDto.setCount(count);
		double networth;

		boolean isValid = webPortalService.isSessionValid(token);		
		if ( isValid && !revokedTokens.contains(token)) {
			networth = webPortalService.sellShares(token, sellDetailsDto);
			model.put("networth", networth);
			log.info("Ending toSellAnAssetController");
			return new ModelAndView("viewNetworth");
		}

		return loginView;
	}

}
