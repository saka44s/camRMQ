package com.camelRMQ.camRMQ.Utility.a;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int counter = 1;
	private int id = counter++;
	
	private String city;
	private int temp;
	private String locality;
	private String dateTime;
}
