package com.cts.portfolio.webportal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetDetailsDto {

	private int id;

	private String assetId;

	private int portfolioId;

	private String assetType;

	private int count;

}
