package com.akshay.comps;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("patient")
@Data
public class PatientInfo {
	
	// direct value injection
	@Value("1234")
	private Integer patientId;
	
	// injecting properties file values
	
	@Value("${pi.name}")
	private String patientName;
	
	@Value("${pi.addr}")
	private String address;
	
	@Value("${pi.mobileNo}")
	private Long mobileNo;
	
	// SPEL based injection
	@Value("#{dcc.xrayPrice + dcc.MRIScanPrice}")
	private Double billAmount;
	
	@Value("#{dcc.ecgPrice <= 0}") // SPEL 
	private Boolean ecgFree;
	
	// system properties injection
	@Value("${os.name}")
	private String osName;
	
	// environment variable values injection
	@Value("${Path}")
	private String path;

}
			