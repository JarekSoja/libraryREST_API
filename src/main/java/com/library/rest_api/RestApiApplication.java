package com.library.rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.library.rest_api.controller", "com.library.rest_api.domain", "com.library.rest_api.dto", "com.library.rest_api.mapper", "com.library.rest_api.repository"})
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);


	}
}
