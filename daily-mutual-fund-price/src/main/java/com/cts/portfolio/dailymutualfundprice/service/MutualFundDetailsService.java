package com.cts.portfolio.dailymutualfundprice.service;

import java.util.List;

import com.cts.portfolio.dailymutualfundprice.dto.MutualFundDetailsDto;
import com.cts.portfolio.dailymutualfundprice.exception.MutualFundNotFoundException;

/**
 * This is a service interface of Mutual Fund.
 */
public interface MutualFundDetailsService {

	public MutualFundDetailsDto getMutualFundByName(String mutualFundName) throws MutualFundNotFoundException;

	public List<Double> getMutualFundPriceByIdList(List<String> mutualFundIdList);

	public boolean isSessionValid(String token);


}
