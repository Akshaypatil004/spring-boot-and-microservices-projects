package com.akshay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.akshay.comps.Employee;

@SpringBootApplication
public class BootApp06ConfigurationPropetiesOnArrayListSetHasAPropertyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BootApp06ConfigurationPropetiesOnArrayListSetHasAPropertyApplication.class, args);
		try (ctx;) {
			
			// get the employee object
			Employee e = ctx.getBean("emp",Employee.class);
			
			System.out.println(e);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
