package com.cts.portfolio.dailyshareprice.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDetailsDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String stockId;
	private String stockName;
	private double stockValue;
}