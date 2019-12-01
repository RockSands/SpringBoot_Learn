package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import com.api.MyClient;

@SpringBootApplication
@EnableFeignClients
public class FeignClientApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(FeignClientApplication.class, args);
		Thread.sleep(5000L);
		MyClient client = context.getBean(MyClient.class);
		long startTime = System.currentTimeMillis();
//		ExecutorService cachedThreadPool = Executors.newFixedThreadPool(10);
//		for (int i = 0; i < 100; i++) {
//			final int a = i;
//			cachedThreadPool.execute(new Runnable() {

//				@Override
//				public void run() {
					System.out.println("--->" + client.method1("aaaa"));
					System.out.println("--->" + client.findById("bbb"));
					System.out.println("--->" + client.get1("auth111"));
//				}
//
//			});

//		}
//		System.out.println("--->" + (System.currentTimeMillis() - startTime));
	}
}
