package com.springboot.example.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import org.springframework.scheduling.annotation.Async;

public class SqsConsumer {

    private volatile boolean stop = false;
    private String queueUrl;
    private AmazonSQS amazonSQS;
    private int waitTimeSeconds;

    public SqsConsumer(boolean stop, String queueUrl,
                       AmazonSQS amazonSQS, int waitTimeSeconds) {
        this.stop = stop;
        this.queueUrl = queueUrl;
        this.amazonSQS = amazonSQS;
        this.waitTimeSeconds = waitTimeSeconds;
    }


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
                    doConsume(message);
                }
            }
        }).start();
    }

    @Async(value = "asyncTask")
    public void doConsume(Message message) {
        System.out.println(message.getBody());
        amazonSQS.deleteMessage(new DeleteMessageRequest().withQueueUrl(queueUrl).withReceiptHandle(message.getReceiptHandle()));
    }

    public void destroy() {
        stop = true;
    }
}
