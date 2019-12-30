package com.test.base.ch.provribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProvribbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvribbonApplication.class, args);
	}

}
