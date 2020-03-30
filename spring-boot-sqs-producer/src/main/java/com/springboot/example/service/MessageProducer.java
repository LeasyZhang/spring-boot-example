package com.springboot.example.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.springboot.example.exception.SQSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MessageProducer {

    private AmazonSQS amazonSQS;

    @Value("${aws.queue.url}")
    private String queueUrl;

    @Autowired
    public MessageProducer(AmazonSQS amazonSQS) {
        this.amazonSQS = amazonSQS;
    }

    public boolean send(String message) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest(queueUrl, message);
        try {
            amazonSQS.sendMessage(sendMessageRequest);
            return true;
        } catch (Exception e) {
            throw new SQSException("Send message error", e);
        }
    }

    public boolean sendBatch(List<String> messageList) {
        if (CollectionUtils.isEmpty(messageList)) {
            return true;
        }
        SendMessageBatchRequest request = new SendMessageBatchRequest();
        request.setQueueUrl(queueUrl);
        Collection<SendMessageBatchRequestEntry> entries = new ArrayList<>();

        for (int i = 0; i < messageList.size(); i++) {
            SendMessageBatchRequestEntry entry = new SendMessageBatchRequestEntry();
            entry.withMessageBody(messageList.get(i));
            entry.withMessageGroupId("default");
            entry.withId(String.valueOf(i));
            entries.add(entry);
        }

        request.withEntries(entries);

        try {
            amazonSQS.sendMessageBatch(request);
            return true;
        } catch (Exception e) {
            throw new SQSException("Send message batch failed", e);
        }
    }
}
