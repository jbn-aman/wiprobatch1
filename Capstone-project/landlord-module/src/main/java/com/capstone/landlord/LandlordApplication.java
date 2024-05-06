package com.capstone.landlord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LandlordApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandlordApplication.class, args);
	}

}
