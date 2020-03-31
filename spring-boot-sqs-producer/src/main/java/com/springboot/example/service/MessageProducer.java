package com.springboot.example.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.google.gson.Gson;
import com.springboot.example.constant.MessageGroup;
import com.springboot.example.exception.SQSException;
import com.springboot.example.util.BatchGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class MessageProducer<T> {

    private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    protected AmazonSQS amazonSQS;

    protected String queueUrl;

    public abstract List<T> prepare();

    public void seedDataBatch() {
        new Thread(() -> {
            List<T> dataList = prepare();

            List<String> messageList = dataList.stream()
                    .map(data -> new Gson().toJson(data))
                    .collect(Collectors.toList());

            BatchGenerator<String> messageGenerator = new BatchGenerator<>(messageList, 10);
            for (List<String> partMessages : messageGenerator) {
                logger.info("Send data batch {}", partMessages.size());
                sendBatch(partMessages, MessageGroup.randomGroup());
            }
        }).start();

    }

    public void seedData() {
        new Thread(() -> {
            List<T> dataList = prepare();
            List<String> messageList = dataList.stream()
                    .map(data -> new Gson().toJson(data))
                    .collect(Collectors.toList());
            messageList.stream().forEach(message -> send(message, MessageGroup.randomGroup()));
        }).start();
    }

    public boolean send(String message, String groupId) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest(queueUrl, message);
        try {
            amazonSQS.sendMessage(sendMessageRequest);
            return true;
        } catch (Exception e) {
            logger.warn("send message", e);
            throw new SQSException("Send message error", e);
        }
    }

    public boolean sendBatch(List<String> messageList, String groupId) {
        Random random = new Random();
        if (CollectionUtils.isEmpty(messageList)) {
            return true;
        }
        SendMessageBatchRequest request = new SendMessageBatchRequest();
        request.setQueueUrl(queueUrl);
        Collection<SendMessageBatchRequestEntry> entries = new ArrayList<>();

        for (int i = 0; i < messageList.size(); i++) {
            SendMessageBatchRequestEntry entry = new SendMessageBatchRequestEntry();
            entry.withMessageBody(messageList.get(i));
            entry.withMessageGroupId(groupId);
            entry.withId(String.valueOf(random.nextInt(Integer.MAX_VALUE)));
            entries.add(entry);
        }

        request.withEntries(entries);

        try {
            amazonSQS.sendMessageBatch(request);
            return true;
        } catch (Exception e) {
            logger.warn("send message batch", e);
            throw new SQSException("Send message batch failed", e);
        }
    }
}
