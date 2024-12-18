package com.app.mqs.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class MessageConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageConsumerApplication.class, args);
	}

}
