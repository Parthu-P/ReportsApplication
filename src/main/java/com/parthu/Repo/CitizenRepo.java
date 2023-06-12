package com.parthu.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.parthu.entity.CitizenPlan;

public interface CitizenRepo extends JpaRepository<CitizenPlan,Integer> {
	
	@Query("select distinct(citizenPlan) from CitizenPlan") 
	 public List<String> getPlanName();
	 
	 @Query("select distinct(citizenStatus) from CitizenPlan")
	 public List<String> getPlanStatus();

}
