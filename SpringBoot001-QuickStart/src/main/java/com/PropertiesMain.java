package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.properties.Author;

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
    
    public static void main(String[] args) {
	SpringApplication.run(PropertiesMain.class, args);
    }
    
    @RequestMapping("/")
    public Author excute() {
	return author;
    }

}
