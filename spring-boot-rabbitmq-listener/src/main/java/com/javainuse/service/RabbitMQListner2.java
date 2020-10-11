package com.javainuse.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListner2 implements MessageListener {

	public void onMessage(Message message) {
		System.out.println("messgae 2: "+message);
		System.out.println("Consuming Message 2- " + new String(message.getBody()));
	}

}