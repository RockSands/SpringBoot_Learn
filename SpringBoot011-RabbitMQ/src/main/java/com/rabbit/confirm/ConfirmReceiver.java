package com.rabbit.confirm;

import java.io.IOException;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
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
public class ConfirmReceiver {

	@RabbitHandler
	public void process(String hello) {
		System.out.println("confirm-Receiver : " + hello);
	}

	@RabbitListener(bindings = @QueueBinding(value = @Queue(name = "confirm-test.queue", durable = "true"), exchange = @Exchange(value = "confirm-test.exchange", type = ExchangeTypes.TOPIC, ignoreDeclarationExceptions = "true"), key = {
			"confirm-test.delete" }))
	public void listenDelete(String context, com.rabbitmq.client.Channel channel, Message message) {
		System.out.println("Receiver confirm-test-delete : " + context);
		try {
			// 通知服务器此消息已经被消费，可从队列删掉， 这样以后就不会重发，否则后续还会在发
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RabbitListener(bindings = @QueueBinding(value = @Queue(name = "confirm-test.queue", durable = "true"), exchange = @Exchange(value = "confirm-test.exchange", type = ExchangeTypes.TOPIC, ignoreDeclarationExceptions = "true"), key = {
			"confirm-test.add" }))
	public void listenAdd(String context, com.rabbitmq.client.Channel channel, Message message) {
		System.out.println("Receiver confirm-test-add : " + context);
		try {
			// 通知服务器此消息已经被消费，可从队列删掉， 这样以后就不会重发，否则后续还会在发
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}