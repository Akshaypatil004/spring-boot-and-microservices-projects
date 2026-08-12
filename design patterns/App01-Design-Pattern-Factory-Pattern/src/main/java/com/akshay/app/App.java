package com.akshay.app;

import com.akshay.comps.Bike;
import com.akshay.factory.BikeFactory;

public class App {
    public static void main(String[] args) {
      Bike bike1 = BikeFactory.orderBike("standard");
      bike1.drive();
      System.out.println("================================");
      
      Bike bike2 = BikeFactory.orderBike("bullet");
      bike2.drive();
      System.out.println("================================");
      
      Bike bike3 = BikeFactory.orderBike("electric");
      bike3.drive();
      System.out.println("================================");
      
      Bike bike4 = BikeFactory.orderBike("sport");
      bike4.drive();
      System.out.println("================================");
    }
}
