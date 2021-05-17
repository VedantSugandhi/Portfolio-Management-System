package com.cts.portfolio.webportal.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AssetSellDetailsDto {

	private int id;
	private String assetId;
	private int count;
	
}
