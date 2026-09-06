package com.akshay.comps;

public final class DieselEngine implements IEngine {
	
	public DieselEngine() {
		System.out.println("DieselEngine.DieselEngine() :: 0-param constructor");
	}

	@Override
	public void startEngine() {
		System.out.println("DieselEngine.startEngine() :: Diesel engine started");
		
	}

	@Override
	public void stopEngine() {
		System.out.println("DieselEngine.stopEngine() :: Diesel engine stop");
		
	}

}
