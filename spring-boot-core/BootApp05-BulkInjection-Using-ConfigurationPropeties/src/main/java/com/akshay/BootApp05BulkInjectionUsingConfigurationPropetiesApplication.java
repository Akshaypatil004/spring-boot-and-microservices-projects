package com.akshay;
import com.akshay.comps.CompanyWithValueAnnoUse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.akshay.comps.Company;

@SpringBootApplication
public class BootApp05BulkInjectionUsingConfigurationPropetiesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BootApp05BulkInjectionUsingConfigurationPropetiesApplication.class, args);
		
		try (ctx;) {
			
			// get the company object ref
			Company com =  ctx.getBean("com",Company.class);
			System.out.println(com);
			
			System.out.println("----------------------------");
			
			CompanyWithValueAnnoUse com1 = ctx.getBean("comwithvalue",CompanyWithValueAnnoUse.class);
			System.out.println(com1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
