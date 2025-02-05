package com.chaithu.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenApp {
	private String fullname;
	private String email;
	private Long phno;
	private String gender;
	private Long ssn;
	private String stateName;
	private LocalDate dob;

}
