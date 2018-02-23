package com;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 访问http://localhost:8080
 * @RestController Rest接口的Controller
 * @SpringBootApplication SpringBoot的入口
 * @author Administrator
 *
 */
@RestController
@SpringBootApplication
public class SampleMain {
    
    public static void main(String[] args) {
	/**
	 * SpringBoot加载Main的方法一,最简操作
	 */
	// SpringApplication.run(SampleMain.class, args);
	/**
	 * setBannerMode(Banner.Mode.OFF): 关闭Banner输出 SpringBoot加载Main的方法二
	 * 
	 * 关闭Springboot的输出
	 * application.setBannerMode(Banner.Mode.OFF);
	 */
	// SpringApplication application = new
	// SpringApplication(SampleMain.class);
	// application.setBannerMode(Banner.Mode.OFF);
	// application.run(args);
	/**
	 * SpringBoot加载Main的方法三 使用SpringApplicationBuilder
	 * 使用Builder推荐使用
	 */
	new SpringApplicationBuilder().sources(SampleMain.class).bannerMode(Banner.Mode.CONSOLE).run(args);
    }
    
    @RequestMapping("/")
    public String excute() {
	return "hello!";
    }
}
