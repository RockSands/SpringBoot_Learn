package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import com.exception.MyException;

@RestController
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.control","com.exception"})
public class ExceptionMain {

	public static void main(String[] args) throws Exception, MyException {
		SpringApplication.run(ExceptionMain.class, args);
	}

}
