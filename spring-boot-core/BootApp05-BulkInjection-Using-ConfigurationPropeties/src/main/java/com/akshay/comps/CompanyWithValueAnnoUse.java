package com.akshay.comps;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component("comwithvalue")
@ToString
public class CompanyWithValueAnnoUse {
	
	@Value("${org.nit.name}")
	private String companyName;
	
	@Value("${org.nit.address}")
	private String address;
	
	@Value("${org.nit.pincode}")
	private Integer pincode;
	
	@Value("${org.nit.contact}")
	private Long contactNo;

}
