package com.ashokit.Binding;

import lombok.Data;

@Data
public class AppDeterminationRes {
  
	private String name;
	private String ssn;
	private String planName;
	private String planStatus;
	private String startDate;
	private String endDate;
	private String benefitAmt;
	private String denialReason;
	private Integer Caseno;
	
}
