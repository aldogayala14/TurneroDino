package com.dinosaurio.turnero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.dinosaurio.turnero"})
public class TurneroApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurneroApplication.class, args);
	}

}
