package com.example.boot.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Component
public class KafkaSenderService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaSenderService.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaSenderService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessages(String message, String topicName) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("Message {} deliver failed.", message, ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("Message {} delivered with offset {}", message, result.getRecordMetadata().offset());
            }
        });
    }
}
