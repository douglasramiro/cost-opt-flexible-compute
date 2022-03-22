package com.amazon.compute.gravitonapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GravitonApplication {

	public static void main(String[] args) {
		SpringApplication.run(GravitonApplication.class, args);
	}

}
