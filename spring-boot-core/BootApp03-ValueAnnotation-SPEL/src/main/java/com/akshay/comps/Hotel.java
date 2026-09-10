package com.akshay.comps;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hotel")
public class Hotel {
	
	@Value("1234") // direct value injection
	private Integer hotelId;
	
	// injecting values collected from properties file
	
	@Value("${hotel.name}")
	private String hotelName;
	
	@Value("${hotel.addr}")
	private String address;
	
	@Value("${hotel.contactno}")
	private Long contactNo;
	
	@Value("${customer.name}")
	private String customerName;
	
	// SPEL for arithmetic operation
	// beadid .property name
	@Value("#{menup.dosaPrice + menup.tea}") // SPEL ( spring expresion language use)
	private Double billAmount;
	
	// injecting system properties value ( system key are fixed )
	
	@Value("${os.name}")
	private String osName;
	
	@Value("${user.name}")
	private String windowsUser;
	
	// injecting environment variable value ( enviroment key are fixed )s
	
	@Value("${Path}")
	private String pathData;

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", address=" + address + ", contactNo="
				+ contactNo + ", customerName=" + customerName + ", billAmount=" + billAmount + ", osName=" + osName
				+ ", windowsUser=" + windowsUser + ", pathData=" + pathData + "]";
	}
}
