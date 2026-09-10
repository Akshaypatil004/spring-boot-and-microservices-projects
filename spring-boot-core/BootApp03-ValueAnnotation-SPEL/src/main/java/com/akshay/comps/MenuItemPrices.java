package com.akshay.comps;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component("menup")
@Data
public class MenuItemPrices {
	
	// injecting values collected from properties file
	
	@Value("${menu.dosarate}")
	private Float dosaPrice;
	
	@Value("${menu.idlyrate}")
	private Float idalyPrice;
	
	@Value("${menu.poharate}")
	private Float pohaPrice;
	
	@Value("${menu.vprate}")
	private Float vadapavPrice;
	
	@Value("${menu.tea}")
	private Float tea;
	

}
