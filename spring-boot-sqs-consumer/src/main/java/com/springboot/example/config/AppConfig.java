package com.springboot.example.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.springboot.example.service.FifoSqsConsumer;
import com.springboot.example.service.StandardSqsConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AppConfig {

    @Value("${aws.fifo-queue.url}")
    private String queueUrl;

    @Value("${aws.standard-queue.url}")
    private String standardQueueUrl;

    @Bean(initMethod = "consume", destroyMethod = "stopConsume")
    public FifoSqsConsumer sqsConsumer() {
        return new FifoSqsConsumer(false, queueUrl, amazonSQS(amazonSQSClientBuilder()), 5, taskExecutor());
    }

    @Bean(initMethod = "consume", destroyMethod = "stopConsume")
    public StandardSqsConsumer standardSqsConsumer() {
        return new StandardSqsConsumer(false, standardQueueUrl, amazonSQS(amazonSQSClientBuilder()), 5, taskExecutor());
    }

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(50);
        executor.initialize();
        return executor;
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
