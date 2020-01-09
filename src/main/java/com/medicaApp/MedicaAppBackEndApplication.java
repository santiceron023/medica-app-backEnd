package com.medicaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//ya no es requerido: org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class medicaAppBackEndApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(medicaAppBackEndApplication.class, args);
	}

	
	//para generar war
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder appBuilder) {
		return appBuilder.sources(medicaAppBackEndApplication.class);
	}
	
	

}
