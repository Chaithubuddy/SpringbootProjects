package com.chaithu.entity;

import java.time.LocalDate;

import com.lowagie.text.pdf.PdfPCell;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ELIGIBILITY_DETAILS")
public class EligibiltyDetails {
	// we are retriving the data so no need of // @GeneratedValue(strategy =
	// GenerationType.IDENTITY)
	
	@Id
	private Integer eligId;
	private String name;
	private Long mobile;
	private String email;
	private Character gender;
	private Long ssn;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private LocalDate createDate;
	private LocalDate updateDate;
	private String createdBy;
	private String updatedBy;

}
