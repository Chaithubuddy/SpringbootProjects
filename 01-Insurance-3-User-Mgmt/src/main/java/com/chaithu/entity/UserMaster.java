package com.chaithu.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_MASTER")
public class UserMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fullName;
	private String email;
	private Long mobileNumber;
	private String gender;
	private LocalDate dob;
	private Long ssn;
	private String password;
	private String activeStatus;
	
	@CreationTimestamp
	@Column(name = "created_Date", updatable = false)
	private LocalDate createdDate;

	@UpdateTimestamp
	@Column(name = "update_Time", insertable = false)
	private LocalDate updateDate;
	
	private String createdBy;
	private String updatedBy;


}
