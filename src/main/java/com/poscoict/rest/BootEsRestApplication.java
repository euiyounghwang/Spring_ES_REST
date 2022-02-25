package com.poscoict.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BootEsRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootEsRestApplication.class, args);
	}

}
