package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自动加载测试
 * 通过/resources/META_INFO/spring.factories,配置Spring自动读取类,并通过@Conditional相关注释达到条件自动加载
 * @author Administrator
 *
 */
@RestController
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.control"})
public class StudentMain {
    
    public static void main(String[] args) {
	SpringApplication.run(StudentMain.class, args);
    }
}
