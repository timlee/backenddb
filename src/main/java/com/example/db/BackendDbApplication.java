package com.example.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.backendDB.controller,com.example.backendDB.exception,com.example.backendDB.service"})
@EnableJpaRepositories("com.example.backendDB.dao")
@EntityScan("com.example.backendDB.pojo")

public class BackendDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendDbApplication.class, args);
	}
}
