package com.app.mqs.consumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.app.mqs.consumer.services.PersonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ActiveMqConsumer {
	
	@Autowired 
	PersonService service;
	
	@JmsListener(destination="Person")
	public void recieve(String message) {
		service.saveMessage(message);
		log.info("Message Received and Saved -> "+ message );	}
}
