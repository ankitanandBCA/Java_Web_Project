package com.househunting.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HouseHuntingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseHuntingApplication.class, args);
		System.out.println("Application run");
	}

}
