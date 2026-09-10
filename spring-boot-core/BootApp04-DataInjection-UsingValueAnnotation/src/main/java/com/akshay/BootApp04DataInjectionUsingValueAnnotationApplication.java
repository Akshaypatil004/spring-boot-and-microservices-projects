package com.akshay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.akshay.comps.PatientInfo;

@SpringBootApplication
public class BootApp04DataInjectionUsingValueAnnotationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BootApp04DataInjectionUsingValueAnnotationApplication.class, args);
		
		try (ctx;) {
			
			// get the patient obj ref
			
			PatientInfo p = ctx.getBean("patient",PatientInfo.class);
			
			System.out.println(p);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
