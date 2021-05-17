package com.cts.portfolio.dailymutualfundprice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * This is a model class for Mutual Fund
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class MutualFundDetails {

	@Id
	@Column
	private String mutualFundId;
	@Column
	private String mutualFundName;
	@Column
	private double mutualFundValue;

}
