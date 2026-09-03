package com.akshay.comps;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("blueDart")
@Lazy(true)
public final class BlueDart implements ICourier {
	
	public BlueDart() {
		System.out.println("BlueDart.BlueDart()");
	}

	@Override
	public String deliver(int oid) {
		return "Blue Dart is ready to deliver " + oid + " order numbers produts";
	}

}
