package com.rabbit.topic;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send() {
		String context = "hello " + new Date();
		sendMessage("add", context);
	}

	/**
	 * 封装发送到消息队列的方法
	 *
	 * @param key: 即routingKey
	 */
	private void sendMessage(String key, final String context) {
		try {
			// 生产一个消息
			System.out.println("Sender : " + key);
			amqpTemplate.convertAndSend("topic-test.exchange", "topic-test." + key, context);
			System.out.println("Sender : OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}