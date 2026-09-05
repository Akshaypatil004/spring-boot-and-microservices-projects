package com.akshay.comps;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("per")
@PropertySource(value = "com/akshay/commons/Info.properties")
public class PersonalInfo {
	
	// injecting properties file values into spring bean properties
	
	@Value("${per.id}")
	private Integer pid;
	
	@Value("${per.name}")
	private String name;
	
	@Value("${per.addr}")
	private String address;
	
	// injecting simple direct values to spring properties
	
	@Value("8456789456")
	private Long mobileNo;
	
	// injecting system properties
	
	@Value("${os.name}")
	private String os_name;
	
	@Value("${os.version}")
	private String os_ver;
	
	// injecting environment values
	
	@Value("${Path}")
	private String path_data;

	@Override
	public String toString() {
		return "PersonalInfo [pid=" + pid + ", name=" + name + ", address=" + address + ", mobileNo=" + mobileNo
				+ ", os_name=" + os_name + ", os_ver=" + os_ver + ", path_data=" + path_data + "]";
	}
	
	
	

}
