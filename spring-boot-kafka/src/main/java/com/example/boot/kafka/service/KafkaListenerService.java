package com.example.boot.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaListenerService.class);

    @KafkaListener(topics = "api-access", groupId = "myGroup")
    @SendTo("reply")
    public String listen(String data) {
        logger.info("receive message {}", data);
        return "reply after receive message";
    }

}
