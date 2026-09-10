package com.akshay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.akshay.comps.Hotel;

@SpringBootApplication
public class BootApp03ValueAnnotationSpelApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BootApp03ValueAnnotationSpelApplication.class, args);
		try (ctx;) {
			
			//get the hotel object
			Hotel hotel = ctx.getBean("hotel",Hotel.class);
			System.out.println(hotel);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}