package com.akshay.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.akshay.comps.DieselEngine;
import com.akshay.comps.ElectricEngine;
import com.akshay.comps.IEngine;
import com.akshay.comps.PetrolEngine;

@Component("eFactory")
@PropertySource("com/akshay/commons/Info.properties")
public class EngineFactory implements FactoryBean<IEngine>{
	
	@Value("${engine.type}")
	private String type;

	@Override
	public IEngine getObject() throws Exception {
		System.out.println("EngineFactory.getObject()");
		
		switch(type) {
		case "petrol" : 
			return new PetrolEngine();
		case "diesel" :
			return new DieselEngine();
		case "electric" : 
			return new ElectricEngine();
		default : 
			throw new IllegalArgumentException("Invalid engine type");
		}
	}

	@Override
	public Class<?> getObjectType() {
		System.out.println("EngineFactory.getObjectType()");
		return IEngine.class;
	}
	
	@Override
	public boolean isSingleton() {
		System.out.println("EngineFactory.isSingleton()");
		return true;
	}

}
