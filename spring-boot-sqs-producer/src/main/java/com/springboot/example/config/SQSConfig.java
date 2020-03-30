package com.springboot.example.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SQSConfig {

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
