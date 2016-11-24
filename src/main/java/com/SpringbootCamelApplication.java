package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.jms.AWSJmsSend;

@SpringBootApplication
public class SpringbootCamelApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringbootCamelApplication.class, args);
		try{
			AWSJmsSend.testAWSQueue();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
