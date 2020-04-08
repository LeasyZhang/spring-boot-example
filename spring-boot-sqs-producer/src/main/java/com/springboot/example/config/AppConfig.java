package com.springboot.example.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.springboot.example.service.NotificationQueueProducer;
import com.springboot.example.service.PriceDeadQueueProducer;
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

    @Value("${aws.price-dead-queue.url}")
    private String priceDeadQueueUrl;

    //@Bean(initMethod = "seedData")
    @Bean
    public NotificationQueueProducer notificationQueueProducer() {
        return new NotificationQueueProducer(amazonSQS(amazonSQSClientBuilder()), notificationQueueUrl);
    }

    //    @Bean(initMethod = "seedDataBatch")
    @Bean
    public PriceQueueProducer priceQueueProducer() {
        return new PriceQueueProducer(amazonSQS(amazonSQSClientBuilder()), priceQueueUrl);
    }

    //@Bean(initMethod = "seedDataBatch")
    @Bean
    public PriceDeadQueueProducer priceDeadQueueProducer() {
        return new PriceDeadQueueProducer(amazonSQS(amazonSQSClientBuilder()), priceDeadQueueUrl);
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
