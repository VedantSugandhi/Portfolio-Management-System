package com.cts.portfolio.dailyshareprice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * This is a model class for Stock
 * 
 * @author POD-1
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StockDetails {

	@Id
	private String stockId;
	private String stockName;
	private double stockValue;

}