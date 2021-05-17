package com.cts.portfolio.networth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MutualFundDetailsDto {
	
	private String mutualFundId;
	private String mutualFundName;
	private int mutualFundValue;
	
}
