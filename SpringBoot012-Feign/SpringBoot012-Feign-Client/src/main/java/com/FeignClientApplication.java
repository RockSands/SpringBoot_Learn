package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import com.api.MyClient;

@SpringBootApplication
@EnableFeignClients
public class FeignClientApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FeignClientApplication.class, args);
		MyClient client = context.getBean(MyClient.class);
		System.out.println("--->" + client.getClass().getName());
		System.out.println("--->" + client.method1("33333"));
		System.out.println("--->" + client.get1(1001L, "ckw"));
	}
}
