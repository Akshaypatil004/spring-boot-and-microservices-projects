package com.akshay.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akshay.cfg.AppConfig;
import com.akshay.comps.Printer;

public class App {
    public static void main(String[] args) {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        try(ctx;){
        	
        	// get target spring bean multiple objects ref
        	Printer p1 = ctx.getBean("printer",Printer.class);
        	Printer p2 = ctx.getBean("printer",Printer.class);
        	Printer p3 = ctx.getBean("printer",Printer.class);
        	
        	// check hashcode 
        	System.out.println("p1.hashcode() :: " + p1.hashCode());
        	System.out.println("p2.hashcode() :: " + p2.hashCode());
        	System.out.println("p3.hashcode() :: " + p3.hashCode());
        	
        	System.out.println("-------------------------------------");
        	
        	System.out.println("p1 == p2 :: " + (p1==p2));
        	System.out.println("p1 == p3 :: " + (p1==p3));
        	System.out.println("p2 == p3 :: " + (p2==p3));
        	
        	
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
