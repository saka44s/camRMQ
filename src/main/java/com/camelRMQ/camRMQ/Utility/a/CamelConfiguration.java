package com.camelRMQ.camRMQ.Utility.a;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class CamelConfiguration {
	
	public static final String RABBIT_URI = "rabbitmq:amq.direct?queue=%s&routingKey=weather&autoDelete=false$connectionFactory=conFactory";
	
	@Bean
	public ConnectionFactory conFactory() {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672);
		factory.setUsername("guest");
		factory.setPassword("guest");
		
		return factory;
	}
	
}
