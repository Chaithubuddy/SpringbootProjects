package com.chaithu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chaithu.entity.EligibiltyDetails;

@Repository
public interface EligibiltyDetailsRepo  extends JpaRepository<EligibiltyDetails, Integer>{
	
	@Query("Select distinct(planName) from EligibiltyDetails")
	public List<String> findPlanNames();
	
	@Query("Select distinct(planStatus) from EligibiltyDetails")
	public List<String> findPlanStatus();

}
