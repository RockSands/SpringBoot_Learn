package com.application.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * spring boot 启动监听类
 */
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartingEvent> {

    private Logger logger = LoggerFactory.getLogger(ApplicationStartedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
	SpringApplication app = event.getSpringApplication();
	app.setBannerMode(Banner.Mode.OFF);// 不显示banner信息
	logger.info("==ApplicationStartedEventListener==");
    }

}