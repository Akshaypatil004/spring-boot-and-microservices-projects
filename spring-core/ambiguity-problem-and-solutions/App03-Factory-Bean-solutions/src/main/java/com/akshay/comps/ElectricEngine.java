package com.akshay.comps;

public final class ElectricEngine implements IEngine {
	
	public ElectricEngine() {
		System.out.println("ElectricEngine.ElectricEngine() :: 0-param constructor");
	}

	@Override
	public void startEngine() {
		System.out.println("ElectricEngine.startEngine() :: Electric engine started");
		
	}

	@Override
	public void stopEngine() {
		System.out.println("ElectricEngine.stopEngine() :: Electric engine stoped");
		
	}

}
