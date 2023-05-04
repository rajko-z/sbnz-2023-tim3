package com.ftn.sbnz2023tim3.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = { "com.ftn.sbnz2023tim3.model", "com.ftn.sbnz2023tim3.kjar" })
@EntityScan(basePackages = "com.ftn.sbnz2023tim3.model.models.tables")
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}

