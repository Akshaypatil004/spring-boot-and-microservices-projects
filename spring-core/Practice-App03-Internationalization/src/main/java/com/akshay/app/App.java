package com.akshay.app;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akshay.config.AppConfig;

public class App {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
       Scanner sc = new Scanner(System.in);
       try(ctx;sc){
    	  // read language code and country code from user
    	   System.out.println("Enter Language code");
    	   String lang = sc.next(); // hi
    	   
    	   System.out.println("Enter country code");
    	   String country = sc.next(); // IN
    	   
    	   // prepare Locale object having language and country code
    	   Locale locale = Locale.of(lang, country);
    	  
    	   // read the msg from locale specific properties file 
    	   String msg1 = ctx.getMessage("welcome.msg", new Object[] {"Akshay"},locale);
    	   String msg2 = ctx.getMessage("goodbye.msg", new Object[] {},locale);
    	   String msg3 = ctx.getMessage("application.title", new Object[] {},locale);
    	   String msg4 = ctx.getMessage("wish.message", new Object[] {},locale);
    	   
    	   // disply msg
    	   System.err.println(msg1 + "...." + msg2 + "...." + msg3 + "...." + msg4);
    	   
       }
       catch(Exception e) {
    	   e.printStackTrace();
       }
    }
}
