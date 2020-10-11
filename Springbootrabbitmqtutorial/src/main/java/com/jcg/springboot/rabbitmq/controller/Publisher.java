package com.jcg.springboot.rabbitmq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

// For creating the REST controllers.
@RestController
// Used to map incoming web requests onto the handler methods in the controller.
@RequestMapping(value = "/api")
public class Publisher {

	private static final Logger LOGGER = LoggerFactory.getLogger(Publisher.class);

	// TODO - 
	@Autowired
	RabbitTemplate rabbitTemplate;
	@Autowired
	Binding binding;

	// HTTP GET url - http://localhost:9091/api/send/{msg}
	@GetMapping(value = "/send/{msg}")
 	@ResponseStatus(code = HttpStatus.OK)
	public String send(@PathVariable("msg") final String message) {
		LOGGER.info("Sending message to the queue.");
		rabbitTemplate.convertAndSend(binding.getExchange(), binding.getRoutingKey(), message);
		LOGGER.info("Message sent successfully to the queue, sending back the response to the user.");
		return "Message sent successfully to the queue.";
	}
}
