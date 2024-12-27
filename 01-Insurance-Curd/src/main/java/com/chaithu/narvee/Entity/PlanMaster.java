package com.chaithu.narvee.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PlanMaster {

	@Id
	@GeneratedValue
	private Integer planId;
	private String planName;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private String activeSW;
	private Integer planCategoryID;

	private String createdBy;
	private String updatedBy;
	

	@CreationTimestamp
	@Column(name = "created_Date", updatable = false)
	private LocalDate createdDate;

	@UpdateTimestamp
	@Column(name = "update_Time", insertable = false)
	private LocalDate updateDate;

}
