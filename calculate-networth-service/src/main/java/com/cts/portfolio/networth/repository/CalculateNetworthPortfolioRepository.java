package com.cts.portfolio.networth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.portfolio.networth.model.AssetDetails;

public interface CalculateNetworthPortfolioRepository extends JpaRepository<AssetDetails, Integer> {
	
	public List<AssetDetails> findByPortfolioIdOrderByAssetId(int portfolioId);
	
	public AssetDetails findByPortfolioIdAndAssetIdAndAssetType(int portfolioId,String assetId,String type);

	public AssetDetails findByPortfolioIdAndAssetId(int portfolioId, String assetId);

	@Modifying
	@Query(value="Delete from asset_details where asset_id =:assetId and portfolio_id=:portfolioId",nativeQuery = true)
	public void deleteByPortfolioIdAndAssetId(@Param("portfolioId") int portfolioId, @Param("assetId") String assetId);


}
