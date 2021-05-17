package com.cts.portfolio.dailymutualfundprice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.portfolio.dailymutualfundprice.model.MutualFundDetails;

/**
 * This is a repository interface of Mutual Fund which extends JpaRepository
 */
public interface MutualFundDetailsRepository extends JpaRepository<MutualFundDetails, Long> {

	/**
	 * This is a boolean method which checks the given mutual fund exists or not in
	 * the database.
	 * 
	 * @param this will take mutualFundName.
	 */
	boolean existsByMutualFundName(String mutualFundName);

	/**
	 * This is a MutualFundDetails method which finds the given mutual fund by name
	 * inside the database.
	 * 
	 * @param this will take mutualFundName.
	 */
	MutualFundDetails findByMutualFundName(String mutualFundName);

	@Query("SELECT m FROM MutualFundDetails m WHERE m.mutualFundId IN (:mutualFundIdList) order by m.mutualFundId")
	public List<MutualFundDetails> findByMutualFundId(@Param("mutualFundIdList") List<String> mutualFundIdList);

}
