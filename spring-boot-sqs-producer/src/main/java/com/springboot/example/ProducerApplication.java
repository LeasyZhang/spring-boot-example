package com.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication springApplication =
                new SpringApplicationBuilder()
                        .sources(ProducerApplication.class)
                        .web(WebApplicationType.NONE)
                        .build();

        springApplication.run(args);
    }
}
