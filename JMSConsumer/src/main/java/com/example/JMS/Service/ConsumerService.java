package com.example.JMS.Service;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {


    private final JmsTemplate jmsTemplate;

    @Autowired
    public ConsumerService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

    public String listener() {
        try {
            String receivedMessage = (String) jmsTemplate.receiveAndConvert("test");

            if (receivedMessage != null) {
                LOGGER.info("Message received successfully: {}", receivedMessage);
                return receivedMessage;
            } else {
                return "No message found";
            }
        } catch (Exception e) {
            LOGGER.error("Error reading message", e);
            return "Error reading message";
        }
    }

}


