package com.example.JMS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
public class SendService {

    private JmsTemplate jmsTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(SendService.class);
    @Autowired
    public SendService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendName(String name){
        try {
            jmsTemplate.convertAndSend("test", name);
            LOGGER.info("Message sent successfully: {}", name);
        } catch (JmsException e) {
            LOGGER.error("Failed to send message: {}", name, e);
        }
    }
}
