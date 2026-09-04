package com.akshay.app;

import com.akshay.ston.Printer;

public class App {
    public static void main(String[] args) {
        Printer p1 = Printer.getInstance();
        Printer p2 = Printer.getInstance();
        
//        Printer p3 = new Printer(); this statement create error , as constructor is not visible outside 
        
        System.out.println(p1.hashCode() + " :: " + p2.hashCode());
        System.out.println("p1 == p2 :: " + (p1==p2));
        p1.printMessage("singleton");
    }
}
