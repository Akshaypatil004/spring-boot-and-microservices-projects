package com.akshay.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Non Option args value :: " + args.getNonOptionArgs());
		
		System.out.println("Option args name & value");
		args.getOptionNames().forEach(name->{
			System.out.println(name + "--> " + 	args.getOptionValues(name));
		});
		
	}

}
