package com.rabbit.confirm;

import java.util.Date;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfirmSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

	@Autowired
	public RabbitTemplate rabbitTemplate;

	public void send() {
		String context = "hello " + new Date();
		sendMessage("add", context);
	}

	/**
	 * 封装发送到消息队列的方法
	 *
	 * @param key: 即routingKey
	 */
	private void sendMessage(String key, String context) {
		try {
			// 生产一个消息
			rabbitTemplate.setConfirmCallback(this);
			rabbitTemplate.convertAndSend("confirm-test.exchange", "confirm-test." + key, context, message -> {
				//注意这里时间要是字符串形式
				message.getMessageProperties().setExpiration("60000");
				return message;
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		System.out.println("sender return success" + message.toString());
	}

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println("=====已消费======");
		if (ack) {
			System.out.println("消息: " + correlationData + "，已经被ack成功");
		} else {
			System.out.println("消息: " + correlationData + "，nack，失败原因是：" + cause);
		}
	}

}