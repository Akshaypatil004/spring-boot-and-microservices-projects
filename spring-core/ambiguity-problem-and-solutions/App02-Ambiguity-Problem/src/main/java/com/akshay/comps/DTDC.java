package com.akshay.comps;

import org.springframework.stereotype.Component;

@Component("dtdc")
public final class DTDC implements ICourier {
	
	public DTDC() {
		System.out.println("DTDC.DTDC()");
	}

	@Override
	public String deliver(int oid) {
		return "DTDC is ready to deliver " + oid + " order numbers produts";
	}

}
