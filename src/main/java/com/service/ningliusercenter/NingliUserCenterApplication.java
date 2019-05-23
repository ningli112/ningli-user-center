package com.service.ningliusercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NingliUserCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(NingliUserCenterApplication.class, args);
	}

}
