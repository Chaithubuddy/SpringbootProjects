 package com.chaithu.narvee.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PlanCategory {

	@Id
	@GeneratedValue
	private Integer planId;
	private String planName;

	private String  activeSW;
	
	//best practice purpose we take 4 
	private String createdBy;
	private String updatedBy;

	@CreationTimestamp
	@Column(name = "Start_Time", insertable = false)
	private LocalDate startTime;

	@UpdateTimestamp
	@Column(name = "End_Time", updatable = false)
	private LocalDate endTime;

}
