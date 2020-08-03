package com.example.boot.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Config {

    @Profile("server")
    @Bean(initMethod = "start")
    public GreetServer server() {
        return new GreetServer();
    }

    @Profile("client")
    @Bean(initMethod = "greet")
    public GrpcClient client() {
        return new GrpcClient();
    }

}
