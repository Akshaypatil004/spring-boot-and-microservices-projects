package com.akshay.factory;

import com.akshay.comps.Bike;
import com.akshay.comps.BulletBike;
import com.akshay.comps.ElectricBike;
import com.akshay.comps.SportBike;
import com.akshay.comps.StandardBike;

public class BikeFactory {
	
	public static Bike orderBike(String bikeType) {
		Bike bike = null;
		if(bikeType.equalsIgnoreCase("standard")) {
			bike = new StandardBike();
		}
		else if(bikeType.equalsIgnoreCase("electric")) {
			bike = new ElectricBike();
		}
		else if(bikeType.equalsIgnoreCase("sport")) {
			bike = new SportBike();
		}
		else if(bikeType.equalsIgnoreCase("bullet")) {
			bike = new BulletBike();
		}
		else {
			throw new IllegalArgumentException("Invalid Bike type");
		}

		
		return bike;
	}

}
