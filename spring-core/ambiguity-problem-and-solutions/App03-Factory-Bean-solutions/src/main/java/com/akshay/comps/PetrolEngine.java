package com.akshay.comps;

public final class PetrolEngine implements IEngine {
	
	public PetrolEngine() {
		System.out.println("PetrolEngine.PetrolEngine() :: 0-param constructor");
	}

	@Override
	public void startEngine() {
		System.out.println("PetrolEngine.startEngine() :: petrol engine started");
		
	}

	@Override
	public void stopEngine() {
		System.out.println("PetrolEngine.stopEngine() :: petrol engine stoped");
		
	}

}
