package com.akshay.ston;

public class Printer {
	
	private static Printer INSTANCE;
	
	/**
	 * private constructor to restrict object creation from new operator , outside of the class
	 */
	private Printer() {
		System.out.println("Printer.Printer() :: private constructor");
	}
	
	// stactic factory method to get single instance
	public static Printer getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Printer();
		}
		return INSTANCE;
	}
	
	public void printMessage(String msg) {
		System.out.println(msg);
	}

}
