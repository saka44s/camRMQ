package com.camelRMQ.camRMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.camelRMQ")
public class RMQApplication {

	public static void main(String[] args) {
		SpringApplication.run(RMQApplication.class, args);
	}

}
