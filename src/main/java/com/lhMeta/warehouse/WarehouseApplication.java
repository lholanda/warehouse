package com.lhMeta.warehouse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// exclude tira do log a password do security
//@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})

@SpringBootApplication
public class WarehouseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-------------------");
		System.out.println("Spring Boot 2022 !!!");
		System.out.println("-------------------");	
	}

}
