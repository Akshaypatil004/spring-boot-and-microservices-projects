package com.akshay.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akshay.cfg.AppConfig;
import com.akshay.comps.SingletonScopeComp;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        try(ctx;){
        	// get the multiple reference of targer spring bean 
        	SingletonScopeComp obj1 = ctx.getBean("single",SingletonScopeComp.class);
        	SingletonScopeComp obj2 = ctx.getBean("single",SingletonScopeComp.class);
        	SingletonScopeComp obj3 = ctx.getBean("single",SingletonScopeComp.class);
        	
        	// hascodes of all three ojects
        	System.out.println("obj1 hascode :: " + obj1.hashCode());//
        	System.out.println("obj2 hascode :: " + obj2.hashCode());// All are having the same hashcode
        	System.out.println("obj3 hascode :: " + obj3.hashCode());// 
        	System.out.println("---------------------------------------");
        	// checking whether all reference variable are pointing to same object reference
        	System.out.println("obj1 == obj2 :: " + (obj1 == obj2));
        	System.out.println("obj1 == obj3 :: " + (obj1 == obj3)); // all these statement returns true
        	System.out.println("obj2 == obj3 :: " + (obj2 == obj3));
        	
        	obj3.getTodaysDate("Akshay");
        	
        	System.out.println("---------------------------------------");
        	// creating object using new operator for SingletonScopeComp clas and check whether is work or not
        	SingletonScopeComp obj4 = new SingletonScopeComp();  
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
