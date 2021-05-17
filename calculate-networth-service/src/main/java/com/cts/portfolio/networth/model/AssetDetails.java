package com.cts.portfolio.networth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class AssetDetails {

	@Id
	@Column
	private int id;
	
	@Column
	private String assetId;
	
	@Column
	private int portfolioId;

	@Column
	private String assetType;

	@Column
	private int count;
	
}
