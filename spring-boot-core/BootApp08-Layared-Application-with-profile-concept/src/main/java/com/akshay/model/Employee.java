package com.akshay.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This is a model/java bean class
 */
@Getter 
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
	
	// employee properties 	
	private Integer eno;
	
	@NonNull
	private String ename;
	
	@NonNull
	private Double salary;
	
	@NonNull
	private String job;
	
	@NonNull
	private Integer deptNo;
	
	private Double grossSalary;
	private Double netSalary;

}
