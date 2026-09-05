package com.akshay.comps;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("demo")
public class Demo {
	
	@Value("${per.name}")
	private String pname;

	@Override
	public String toString() {
		return "Demo [pname=" + pname + "]";
	}

	
}
