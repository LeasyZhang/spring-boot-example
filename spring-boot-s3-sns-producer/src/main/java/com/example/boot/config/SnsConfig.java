package com.example.boot.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnsConfig {

    @Bean
    public AmazonSNSClientBuilder snsClientBuilder() {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        final int connectionTimeout = 3000;
        clientConfiguration.setConnectionTimeout(connectionTimeout);
        clientConfiguration.setProtocol(Protocol.HTTPS);
        clientConfiguration.setUseTcpKeepAlive(true);

        return AmazonSNSClientBuilder.standard().withClientConfiguration(clientConfiguration);
    }

    @Bean
    public AmazonSNS amazonSNS(AmazonSNSClientBuilder builder) {
        return builder.build();
    }
}
