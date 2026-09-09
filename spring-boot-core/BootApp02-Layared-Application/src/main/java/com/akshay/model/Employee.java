package com.akshay.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This is a model/java bean class
 */
@Getter 
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
	
	// employee properties 	
	private Integer eno;
	private String ename;
	private String job;
	private Double salary;
	private Integer deptNo;
	private Double grossSalary;
	private Double netSalary;

}
