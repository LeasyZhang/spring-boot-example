package com.springboot.example;

import com.springboot.example.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication springApplication =
                new SpringApplicationBuilder()
                        .sources(ConsumerApplication.class)
                        .web(WebApplicationType.NONE)
                        .build();

        springApplication.run(args);
    }
}
