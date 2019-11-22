package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import com.api.MyClient;

@SpringBootApplication
@EnableFeignClients
public class FeignClientApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FeignClientApplication.class, args);
		MyClient client = context.getBean(MyClient.class);
		// long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			System.out.println("--->" + client.method1("" + i));
		}
		// System.out.println("--->" + (System.currentTimeMillis() - startTime));
	}
}
