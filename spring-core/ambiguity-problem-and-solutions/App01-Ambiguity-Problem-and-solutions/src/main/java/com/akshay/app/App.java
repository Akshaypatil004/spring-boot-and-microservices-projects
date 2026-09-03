package com.akshay.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akshay.cfg.AppConfig;
import com.akshay.sbeans.AmbiguityProblem;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new  AnnotationConfigApplicationContext(AppConfig.class);
        try(ctx;){
        	// get the spring bean ref
        	AmbiguityProblem am = ctx.getBean("ambiguity",AmbiguityProblem.class);
        	
        	System.out.println(am);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
