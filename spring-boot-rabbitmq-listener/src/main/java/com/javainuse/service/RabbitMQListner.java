package com.javainuse.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListner implements MessageListener {

	public void onMessage(Message message) {
		System.out.println("messgae 1: "+message);
		System.out.println("Consuming Message 1- " + new String(message.getBody()));
	}

}