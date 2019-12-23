package com.medicaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MedicaAppBackEndApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MedicaAppBackEndApplication.class, args);
	}

	
	//para generar war
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder appBuilder) {
		return appBuilder.sources(MedicaAppBackEndApplication.class);
	}
	
	

}
