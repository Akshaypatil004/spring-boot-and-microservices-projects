package com.akshay.comps;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("dcc")
@Data
public class DianosticCenterCatalog {
	
	// injecting values collected from properties file into sping bean properties
	
	@Value("${dc.xrayRate}")
	private Double xrayPrice;
	
	@Value("${dc.ctscanRate}")
	private Double ctscanPrice; 
	
	@Value("${dc.mriscanRate}")
	private Double MRIScanPrice;
	
	@Value("${dc.ecgRate}")
	private Double ecgPrice;

}
