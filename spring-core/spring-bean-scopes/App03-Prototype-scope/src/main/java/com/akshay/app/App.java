package com.akshay.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akshay.cfg.AppConfig;
import com.akshay.comps.PrototypeScopeDemo;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        try(ctx;){
        	
        	// get target spring bean multiple objects ref
        	PrototypeScopeDemo p1 = ctx.getBean("proto",PrototypeScopeDemo.class);
        	PrototypeScopeDemo p2 = ctx.getBean("proto",PrototypeScopeDemo.class);
        	PrototypeScopeDemo p3 = ctx.getBean("proto",PrototypeScopeDemo.class);
        	
        	// check hashcode 
        	System.out.println("p1.hashcode() :: " + p1.hashCode());
        	System.out.println("p2.hashcode() :: " + p2.hashCode());
        	System.out.println("p3.hashcode() :: " + p3.hashCode());
        	
        	System.out.println("-------------------------------------");
        	
        	System.out.println("p1 == p2 :: " + (p1==p2));
        	System.out.println("p1 == p3 :: " + (p1==p3));
        	System.out.println("p2 == p3 :: " + (p2==p3));
        	
        	System.out.println("-------------------------------------");
        	
        	p1.getTodaysDate("Akshay");
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
