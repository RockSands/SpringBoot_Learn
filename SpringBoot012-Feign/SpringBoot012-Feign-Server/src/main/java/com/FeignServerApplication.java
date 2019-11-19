package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@EnableFeignClients
@SpringBootApplication
public class FeignServerApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FeignServerApplication.class, args);
	}
}
