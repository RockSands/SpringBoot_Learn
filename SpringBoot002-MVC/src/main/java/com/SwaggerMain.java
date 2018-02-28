package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 生成API页面
 * @author Administrator
 * 访问地址:http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.control","com.swagger"})
public class SwaggerMain {

    public static void main(String[] args) {
	SpringApplication.run(SwaggerMain.class, args);
    }

}
