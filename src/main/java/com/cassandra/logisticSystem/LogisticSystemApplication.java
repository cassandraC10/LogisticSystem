package com.cassandra.logisticSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.cassandra.logisticSystem")
public class LogisticSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticSystemApplication.class, args);
	}

}
