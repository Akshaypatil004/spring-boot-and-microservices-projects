package com.akshay.comps;

import org.springframework.stereotype.Component;

@Component("blueDart")
public final class BlueDart implements ICourier {
	
	public BlueDart() {
		System.out.println("BlueDart.BlueDart()");
	}

	@Override
	public String deliver(int oid) {
		return "Blue Dart is ready to deliver " + oid + " order numbers produts";
	}

}
