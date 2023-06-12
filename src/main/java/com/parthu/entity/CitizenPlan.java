package com.parthu.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CITIZEN_PLAN")
public class CitizenPlan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer citizenId;
	
	private String citizenName;
	private String citizenPlan;
	private String citizenStatus;
	private LocalDate citizenPlanStartDate;
	private LocalDate citizenPlanEndDate;
	private String citizenGender;
	private String deniedReason;
	private LocalDate deniedDate;
	private Double beneficiaryAmount;
	private LocalDate terminateDate;
	private LocalDate terminateEndDate;
	private String terminateReason;
	

}
