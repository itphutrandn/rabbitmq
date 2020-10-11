package com.javainuse.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.client.AMQP.Exchange;

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/direct/")
public class RabbitMQDirectWebController {
	
	@Autowired
	private AmqpTemplate amqpTemplate;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("exchangeName") String exchange, @RequestParam("routingKey") String routingKey,
			@RequestParam("messageData") String messageData) {

		amqpTemplate.convertAndSend(exchange, routingKey, messageData);

		return "Message sent to the RabbitMQ Successfully";
	}

}