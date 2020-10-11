package com.javainuse.listen;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectListen {
	/*
	@RabbitListener(queues = "adminQueue")
	public void listenAdmin(String message) {
		System.out.println("message : "+message);
	}
	
	@RabbitListener(queues = "financeQueue")
	public void listenFinanceQueue(String message) {
		System.out.println("message financeQueue: "+message);
	}
	*/
}
