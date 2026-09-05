package com.akshay.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akshay.config.AppConfig;
import com.akshay.comps.Flipkart;

public class App {
    public static void main(String[] args) {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        try(ctx;){
     	   // get the target spring bean
     	   Flipkart flipkart = ctx.getBean("flipkart",Flipkart.class);
     	   
     	   // invoke the businees method
     	   String msg = flipkart.shopping(new String[] {"shirt","trouser"}, new double[] {9000.0,5000.0});
     	   
     	   System.out.println(msg);
        }
        catch(Exception e) {
     	   e.printStackTrace();
        }
    }
}
