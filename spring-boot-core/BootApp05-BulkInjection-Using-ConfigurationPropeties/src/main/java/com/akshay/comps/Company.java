package com.akshay.comps;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("com")
@Setter
@ToString
@ConfigurationProperties(prefix = "org.nit")
public class Company {

	private String name;
	private String address;
	private Integer pincode;
	private Long contact;
	
}
