package com.cinemas.neon.neonuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NeonUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeonUserServiceApplication.class, args);
	}

}
