package com.akshay;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.akshay.comps.SeasonFinder;

@SpringBootApplication
public class BootApp01DependencyInjectionApplication {
	
	@Bean("dt")
	public LocalDate createDate() {
		System.out.println("BootApp01DependencyInjectionApplication.createDate()");
		
		return LocalDate.now();
	}

	public static void main(String[] args) {
		System.out.println("BootApp01DependencyInjectionApplication.main() :: start");
		// get the IOC container 
		ConfigurableApplicationContext ctx = SpringApplication.run(BootApp01DependencyInjectionApplication.class, args);
		
		try(ctx;){
			
			// get the targert class
			SeasonFinder season = ctx.getBean("seasonFinder", SeasonFinder.class);
			
			// invoked the businnes method
			String result = season.findSeason();
			
			System.out.println(result);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("BootApp01DependencyInjectionApplication.main() :: end");
	}

}
