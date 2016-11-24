package com.springboot.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.aws.outbound.SqsMessageHandler;
import org.springframework.messaging.MessageHandler;

import com.amazonaws.services.sqs.AmazonSQS;

@Configuration
public class SqsSenderConfig {

    @Autowired
    private AmazonSQS amazonSqs;

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate() {
        return new QueueMessagingTemplate(this.amazonSqs);
    }

    @Bean
    @ServiceActivator(inputChannel = "sqsSendChannel")
    public MessageHandler sqsMessageHandler() {
    	SqsMessageHandler sqsMessageHandler = new SqsMessageHandler(queueMessagingTemplate());
    	sqsMessageHandler.setQueue("petQueue");
    	return sqsMessageHandler();
    }
}
