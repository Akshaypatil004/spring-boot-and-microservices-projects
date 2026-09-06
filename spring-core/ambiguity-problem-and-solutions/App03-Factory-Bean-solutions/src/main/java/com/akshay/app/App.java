package com.akshay.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akshay.comps.IEngine;
import com.akshay.comps.Vehicle;
import com.akshay.config.AppConfig;

public class App {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
       
       try(ctx;){
    	   // get targer spring bean object ref
    	   
    	   Vehicle vehicle = ctx.getBean("vehicle",Vehicle.class);
    	   
    	   // invoked the business method
    	   vehicle.journey("hyd", "vooty");
    	   
    	   System.out.println("====================================");
    	   IEngine engine = ctx.getBean("eFactory",IEngine.class);
    	   System.out.println("enige type : " + engine.getClass());
       }
       catch(Exception e) {
    	   e.printStackTrace();
       }
    }
}
