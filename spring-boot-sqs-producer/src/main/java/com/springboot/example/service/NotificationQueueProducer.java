package com.springboot.example.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.springboot.example.message.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;


public class NotificationQueueProducer extends MessageProducer<Notification> {

    private final int messageSize = 1000;

    public NotificationQueueProducer(AmazonSQS amazonSQS, String queueUrl) {
        this.amazonSQS = amazonSQS;
        this.queueUrl = queueUrl;
    }

    @Override
    public List<Notification> prepare() {
        List<Notification> notificationList = new ArrayList<>(messageSize);
        Random generator = new Random();
        for (int i = 0; i < messageSize; i++) {
            Notification newNotification = new Notification();
            newNotification.setUerId(generator.nextInt(10000) + 1);
            newNotification.setMessage(UUID.randomUUID().toString());
            notificationList.add(newNotification);
        }
        return notificationList;
    }
}
