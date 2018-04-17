package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import com.service.ServiceList;

@RestController
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.properties","com.service"})
public class ListServiceMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ListServiceMain.class, args);
		ServiceList serviceList = context.getBean(ServiceList.class);
		serviceList.excute();
	}
}
