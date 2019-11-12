package com.springboot.example.queue;

import com.springboot.example.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Session;

import static com.springboot.example.config.ActiveMQConfig.ORDER_QUEUE;

@Component
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @JmsListener(destination = ORDER_QUEUE)
    public void receiveMessage(@Payload Order order,
                               @Headers MessageHeaders headers,
                               Message message, Session session) {
        logger.info("received <" + order + ">");

        logger.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        logger.info("######          Message Details           #####");
        logger.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        logger.info("headers: " + headers);
        logger.info("message: " + message);
        logger.info("session: " + session);
        logger.info("- - - - - - - - - - - - - - - - - - - - - - - -");
    }
}
