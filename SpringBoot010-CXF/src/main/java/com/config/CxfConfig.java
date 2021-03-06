package com.config;

import java.util.Properties;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.UserService;
import com.service.UserServiceImpl;

@Configuration
public class CxfConfig {
	/**
	 * 定义URL公用部分
	 * @return
	 */
	@Bean
	public ServletRegistrationBean dispatcherServlet() {
		Properties properties = System.getProperties();
		properties.put("org.apache.cxf.stax.allowInsecureParser", "1");
		return new ServletRegistrationBean(new CXFServlet(), "/test/*");
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), userService());
		endpoint.publish("/user");
		return endpoint;
	}
}
