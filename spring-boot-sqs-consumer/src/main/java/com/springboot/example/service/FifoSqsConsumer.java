package com.springboot.example.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.time.Instant;

public class FifoSqsConsumer implements SqsConsumer {

    private volatile boolean stop = false;
    private String queueUrl;
    private AmazonSQS amazonSQS;
    private int waitTimeSeconds;
    private ThreadPoolTaskExecutor taskExecutor;

    public FifoSqsConsumer(boolean stop, String queueUrl,
                           AmazonSQS amazonSQS, int waitTimeSeconds,
                           ThreadPoolTaskExecutor taskExecutor) {
        this.stop = stop;
        this.queueUrl = queueUrl;
        this.amazonSQS = amazonSQS;
        this.waitTimeSeconds = waitTimeSeconds;
        this.taskExecutor = taskExecutor;
    }

    @Override
    public void consume() {

        new Thread(() -> {
            while (true) {
                if (stop) {
                    break;
                }

                ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest()
                        .withWaitTimeSeconds(waitTimeSeconds)
                        .withQueueUrl(queueUrl);
                ReceiveMessageResult result = amazonSQS.receiveMessage(receiveMessageRequest);

                for (Message message : result.getMessages()) {
                    taskExecutor.submit(() -> doConsume(message));
                }
            }
        }).start();
    }

    public void doConsume(Message message) {
        String printed = new StringBuilder()
                .append(Thread.currentThread().getId()).append("-->")
                .append(Thread.currentThread().getName()).append("-->")
                .append(message.getBody()).append("-->")
                .append(message.getMessageId()).append("-->")
                .append(Instant.now())
                .toString();
        System.out.println(printed);
        //amazonSQS.deleteMessage(new DeleteMessageRequest().withQueueUrl(queueUrl).withReceiptHandle(message.getReceiptHandle()));
    }

    @Override
    public void stopConsume() {
        stop = true;
    }
}
