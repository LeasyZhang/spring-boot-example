package com.example.boot.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SnsSenderService {

    private static final Logger logger = LoggerFactory.getLogger(SnsSenderService.class);

    private final AmazonSNS amazonSNS;

    public SnsSenderService(AmazonSNS amazonSNS) {
        this.amazonSNS = amazonSNS;
    }

    public String send(String topic, String message) {
        PublishResult result = amazonSNS.publish(topic, message);
        int response = result.getSdkHttpMetadata().getHttpStatusCode();
        if (response != HttpStatus.SC_OK) {
            logger.warn("Publish message {} to topic {} failed, response code {}", message, topic, response);
        }
        return result.getMessageId();
    }

    public void subscribe(String topic, String email) {
        SubscribeRequest request = new SubscribeRequest();
        request.setProtocol("email");
        request.setEndpoint(email);
        request.setReturnSubscriptionArn(true);
        request.setTopicArn(topic);
        SubscribeResult result = amazonSNS.subscribe(request);
        logger.info("Subscription ARN: {} \n\n Status was {}", result.getSubscriptionArn(), result.getSdkHttpMetadata().getHttpStatusCode());
    }
}
