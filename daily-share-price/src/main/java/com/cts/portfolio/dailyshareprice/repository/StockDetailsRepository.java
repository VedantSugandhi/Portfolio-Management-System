package com.cts.portfolio.dailyshareprice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.portfolio.dailyshareprice.model.StockDetails;

/**
 * This is a repository interface of Stock which extends JpaRepository
 */
public interface StockDetailsRepository extends JpaRepository<StockDetails, String> {

	/**
	 * This is a boolean method which checks the given stock exists or not in
	 * the database.
	 * 
	 * @param this will take stockName.
	 */
	boolean existsByStockName(String stockName);


	/**
	 * This is a MutualFundDetails method which finds the given stock by name
	 * inside the database.
	 * 
	 * @param this will take stockName.
	 */
	public StockDetails findByStockName(String stockName);


	@Query("SELECT s FROM StockDetails s WHERE s.stockId IN (:stockId) order by s.stockId")
	public List<StockDetails> findByStockId(@Param("stockId") List<String> stockId);
}
