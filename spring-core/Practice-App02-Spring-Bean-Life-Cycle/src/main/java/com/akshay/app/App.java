package com.akshay.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akshay.comps.CheckingVotingEligibity;
import com.akshay.config.AppConfig;

public class App {
    public static void main(String[] args) {
      AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
      try(ctx;){
    	  
    	  // get the target spring bean obj ref
    	  CheckingVotingEligibity voter = ctx.getBean("voter",CheckingVotingEligibity.class);
    	  
    	  // invoked the business method
    	  String result = voter.checkEligibility();
    	  System.out.println(result);
      }
      catch(Exception e) {
    	  e.printStackTrace();
      }
    }
}
