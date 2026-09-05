package com.akshay.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("com/akshay/cfg/applicationContext.xml")
@ComponentScan(basePackages = "com.akshay.comps")
public class AppConfig {

}
