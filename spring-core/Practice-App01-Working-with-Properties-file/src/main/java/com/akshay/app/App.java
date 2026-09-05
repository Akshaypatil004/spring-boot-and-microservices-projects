package com.akshay.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akshay.cfg.AppConfig;
import com.akshay.comps.Demo;
import com.akshay.comps.PersonalInfo;

public class App {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
       
       try(ctx;){
    	   
    	   // get spring bean obj ref
    	   PersonalInfo person  = ctx.getBean("per",PersonalInfo.class);
    	   System.out.println(person);
    	   
    	   System.out.println("------------------------------------------");
    	   
    	   Demo d = ctx.getBean("demo",Demo.class);
    	   System.out.println(d);
       }
       catch(Exception e) {
    	   e.printStackTrace();
       }
    }
}
