package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *	跳转配置项,写死
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/admin").setViewName("admin");
		registry.addViewController("/user").setViewName("user");
		registry.addViewController("/vip").setViewName("vip");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/super").setViewName("super");
		registry.addViewController("/deny").setViewName("deny");
	}

}
