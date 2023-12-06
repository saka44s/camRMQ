package com.camelRMQ.camRMQ.Routes.a;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.support.DefaultMessage;
import org.springframework.stereotype.Component;

import com.camelRMQ.camRMQ.Utility.a.WeatherDTO;


@Component
public class WeatherRoute extends RouteBuilder{

	// Step 1
	public void configure1() throws Exception {
		from("rabbitmq:amq.direct?queue=weather&routingKey=weather&autoDelete=false&connectionFactory=conFactory")
		.log(LoggingLevel.ERROR, "${body}");
	}
	
	public void configure2() throws Exception {
		from("rabbitmq:amq.direct?queue=weather&routingKey=weather&autoDelete=false&connectionFactory=conFactory")
		.log(LoggingLevel.ERROR, "${body}")
		.unmarshal().json(JsonLibrary.Jackson,WeatherDTO.class)
		.process(this::enrichDTO)
		.log(LoggingLevel.ERROR, "${body}");
	}

	
	public void configure() throws Exception {
		from("rabbitmq:amq.direct?queue=weather&routingKey=weather&autoDelete=false&connectionFactory=conFactory")
		.log(LoggingLevel.ERROR, "${body}")
		.unmarshal().json(JsonLibrary.Jackson,WeatherDTO.class)
		.process(this::enrichDTO)
		.log(LoggingLevel.ERROR, "${body}")
		.marshal().json(JsonLibrary.Jackson,WeatherDTO.class)
		.to("rabbitmq:amq.direct?queue=weather-other&routingKey=weatherOther&autoDelete=false&connectionFactory=conFactory");
	}
	
	public void enrichDTO(Exchange exchange) {
		WeatherDTO dto =  exchange.getMessage().getBody(WeatherDTO.class);
		dto.setDateTime(new Date().toString());
		
		Message message = new DefaultMessage(exchange);
		message.setBody(dto);
		exchange.setMessage(message);
		
	}

}
