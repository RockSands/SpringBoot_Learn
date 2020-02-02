package com.rabbit.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 对队列的监听
 */
@Component
public class TopicReceiver {

	@RabbitHandler
	public void process(String hello) {
		System.out.println("topic-Receiver : " + hello);
	}

	@RabbitListener(bindings = @QueueBinding(value = @Queue(name = "topic-test.queue", durable = "true"), exchange = @Exchange(value = "topic-test.exchange", type = ExchangeTypes.TOPIC, ignoreDeclarationExceptions = "true"), key = {
			"topic-test.delete"}))
	public void listenDelete(String context) {
		System.out.println("Receiver Topic-test-delete : " + context);
	}

	@RabbitListener(bindings = @QueueBinding(value = @Queue(name = "topic-test.queue", durable = "true"), exchange = @Exchange(value = "topic-test.exchange", type = ExchangeTypes.TOPIC, ignoreDeclarationExceptions = "true"), key = {
			"topic-test.add"}))
	public void listenAdd(String context) {
		System.out.println("Receiver Topic-test-add : " + context);
	}
}