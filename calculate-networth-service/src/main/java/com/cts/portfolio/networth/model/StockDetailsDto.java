package com.cts.portfolio.networth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockDetailsDto {

	private String stockId;
	private String stockName;
	private double stockValue;	
	
}
