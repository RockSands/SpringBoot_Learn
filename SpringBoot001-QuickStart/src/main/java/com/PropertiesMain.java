package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.properties.Admin;
import com.properties.Author;

/**
 * 配置文件测试
 * 
 * @author Administrator
 *
 */
@RestController
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.properties")
public class PropertiesMain {
	/**
	 * 自动绑定,author是读取配置文件读出的数据
	 */
	@Autowired
	private Author author;

	@Autowired
	private Admin admin;

	public static void main(String[] args) {
		SpringApplication.run(PropertiesMain.class, args);
	}

	@RequestMapping("/")
	public Author author() {
		return author;
	}

	@RequestMapping("/admin")
	public Admin admin() {
		return admin;
	}

}
