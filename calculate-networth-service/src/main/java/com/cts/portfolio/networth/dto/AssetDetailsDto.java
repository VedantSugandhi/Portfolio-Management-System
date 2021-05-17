package com.cts.portfolio.networth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetDetailsDto {

	private int id;

	private String assetId;
	
	private int portfolioId;

	private String assetType;

	private int count;
	
}
