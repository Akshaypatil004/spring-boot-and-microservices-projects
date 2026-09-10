package com.akshay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.akshay.comps.Customer;

@SpringBootApplication
public class BootApp07WorkingWithYmlApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BootApp07WorkingWithYmlApplication.class, args);
		try (ctx;) {
			
			Customer cust = ctx.getBean("cust",Customer.class);
			System.out.println(cust);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
