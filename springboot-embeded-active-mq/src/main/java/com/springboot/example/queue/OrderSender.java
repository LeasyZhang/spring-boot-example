package com.springboot.example.queue;

import com.springboot.example.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import static com.springboot.example.config.ActiveMQConfig.ORDER_QUEUE;

@Component
public class OrderSender {

    private static final Logger logger = LoggerFactory.getLogger(OrderSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(Order message) {
        logger.info("sending to queue {}", message);
        jmsTemplate.convertAndSend(ORDER_QUEUE, message);
    }
}
