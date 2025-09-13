package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan(basePackages = "com.example.model")
@EnableFeignClients(basePackages = "com.example.demo.FeignClient")
public class MicroserviceMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceMainApplication.class, args);
	}

}
