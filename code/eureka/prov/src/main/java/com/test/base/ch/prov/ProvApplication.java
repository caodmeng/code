package com.test.base.ch.prov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvApplication.class, args);
	}

}
