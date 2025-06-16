package com.spring_api_database.api_second_task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public abstract class ApiSecondTaskApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiSecondTaskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
