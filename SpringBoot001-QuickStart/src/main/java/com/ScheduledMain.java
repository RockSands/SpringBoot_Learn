package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @EnableScheduling定时任务必须开启
 *
 */
@Configuration
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan({"com.scheduled"})
public class ScheduledMain {

    public static void main(String[] args) {
	SpringApplication.run(ScheduledMain.class, args);
    }

}
