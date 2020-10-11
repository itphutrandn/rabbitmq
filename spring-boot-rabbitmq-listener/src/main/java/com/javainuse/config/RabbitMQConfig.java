package com.javainuse.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javainuse.service.RabbitMQListner;

@Configuration
public class RabbitMQConfig {

	@Value("${javainuse.rabbitmq.queue1}")
	String queueName1;

	@Value("${javainuse.rabbitmq.queue2}")
	String queueName2;

	@Value("${spring.rabbitmq.username}")
	String username;

	@Value("${spring.rabbitmq.password}")
	private String password;

	@Bean
	Queue queue01() {
		return new Queue(queueName1, false);
	}

	@Bean
	Queue queue02() {
		return new Queue(queueName2, false);
	}

	@Bean
	MessageListenerContainer messageListenerContainer1(ConnectionFactory connectionFactory) {
		System.out.println("connectionFactory 1:" + connectionFactory);
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
		simpleMessageListenerContainer.setQueues(queue01());
		simpleMessageListenerContainer.setMessageListener(new RabbitMQListner());
		return simpleMessageListenerContainer;

	}
	
	@Bean
	MessageListenerContainer messageListenerContainer2(ConnectionFactory connectionFactory) {
		System.out.println("connectionFactory 2:" + connectionFactory);
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
		simpleMessageListenerContainer.setQueues(queue02());
		simpleMessageListenerContainer.setMessageListener(new RabbitMQListner());
		return simpleMessageListenerContainer;

	}
	/*
	 * @Bean ConnectionFactory connectionFactory() { CachingConnectionFactory
	 * cachingConnectionFactory = new CachingConnectionFactory("localhost");
	 * cachingConnectionFactory.setUsername(username);
	 * cachingConnectionFactory.setUsername(password); return
	 * cachingConnectionFactory; }
	 * 
	 * 
	 * /*@Bean MessageListenerContainer messageListenerContainer() {
	 * SimpleMessageListenerContainer simpleMessageListenerContainer = new
	 * SimpleMessageListenerContainer();
	 * simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
	 * simpleMessageListenerContainer.setQueues(queue());
	 * simpleMessageListenerContainer.setMessageListener(new RabbitMQListner());
	 * return simpleMessageListenerContainer;
	 * 
	 * }
	 */

}
