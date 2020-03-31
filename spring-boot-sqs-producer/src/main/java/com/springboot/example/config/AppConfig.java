package com.springboot.example.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.springboot.example.service.NotificationQueueProducer;
import com.springboot.example.service.PriceQueueProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${aws.notification-queue.url}")
    private String notificationQueueUrl;

    @Value("${aws.price-queue.url}")
    private String priceQueueUrl;

    @Bean(initMethod = "seedData")
    public NotificationQueueProducer notificationQueueProducer() {
        return new NotificationQueueProducer(amazonSQS(amazonSQSClientBuilder()), notificationQueueUrl);
    }

    @Bean(initMethod = "seedDataBatch")
    public PriceQueueProducer priceQueueProducer() {
        return new PriceQueueProducer(amazonSQS(amazonSQSClientBuilder()), priceQueueUrl);
    }

    @Bean
    public AmazonSQSClientBuilder amazonSQSClientBuilder() {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        final int connectionTimeout = 3000;
        clientConfiguration.setConnectionTimeout(connectionTimeout);
        clientConfiguration.setProtocol(Protocol.HTTPS);
        clientConfiguration.setUseTcpKeepAlive(true);

        return AmazonSQSClientBuilder.standard().withClientConfiguration(clientConfiguration);
    }

    @Bean
    public AmazonSQS amazonSQS(AmazonSQSClientBuilder amazonSQSClientBuilder) {
        return amazonSQSClientBuilder.build();
    }
}
