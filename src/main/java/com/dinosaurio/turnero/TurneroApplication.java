package com.dinosaurio.turnero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication(scanBasePackages={
		"com.dinosaurio.turnero"})
public class TurneroApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurneroApplication.class, args);
	}



}
