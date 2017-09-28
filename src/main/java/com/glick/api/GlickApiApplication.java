package com.glick.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.glick.api.config.property.GlickApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(GlickApiProperty.class)
public class GlickApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlickApiApplication.class, args);
	}
	
}
