package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import com.logger.console.Logger00;

@RestController
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.logger")
public class LoggerMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LoggerMain.class, args);
		Logger00 logger00 = context.getBean(Logger00.class);
		logger00.log();
	}
}
