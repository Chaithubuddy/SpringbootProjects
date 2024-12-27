package com.chaithu.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SerachReqest {
	
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;

}
