package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.rabbit.confirm.ConfirmSender;
import com.rabbit.confirm.ConfirmSender2;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	ConfigurableApplicationContext contest = SpringApplication.run(Application.class, args);
    	ConfirmSender confirmSender = contest.getBean(ConfirmSender.class);
    	confirmSender.send();
    	ConfirmSender2 confirmSender2 = contest.getBean(ConfirmSender2.class);
    	confirmSender2.send();
//    	TopicSender sender = contest.getBean(TopicSender.class);
//    	sender.send();
    }

}