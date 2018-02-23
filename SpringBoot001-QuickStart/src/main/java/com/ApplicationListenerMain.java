package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.application.listener.ApplicationEnvironmentPreparedEventListener;
import com.application.listener.ApplicationFailedEventListener;
import com.application.listener.ApplicationPreparedEventListener;
import com.application.listener.ApplicationStartedEventListener;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.application")
public class ApplicationListenerMain {
    public static void main(String[] args) {
	SpringApplication app = new SpringApplication(ApplicationListenerMain.class);
	app.addListeners(new ApplicationEnvironmentPreparedEventListener());
	app.addListeners(new ApplicationFailedEventListener());
	app.addListeners(new ApplicationPreparedEventListener());
	app.addListeners(new ApplicationStartedEventListener());
	app.run(args);
    }
}
