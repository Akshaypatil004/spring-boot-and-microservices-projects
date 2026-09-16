package com.akshay.model;

import lombok.Data;

@Data
public class Student {
	
	private Integer sno;
	private String sname;
	private String saddr = "hyb";
	private float avg;

}
