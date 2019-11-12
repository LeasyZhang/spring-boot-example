package com.springboot.example;

import com.springboot.example.model.Order;
import com.springboot.example.queue.OrderSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class BootApplication implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(BootApplication.class);

    @Autowired
    private OrderSender orderSender;

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("SpringBoot embeded ActiveMQ example");

        for(int i = 0; i < 5; i++) {
            Order message = new Order(i + " - Sending JMS Message using Embedded activeMQ", new Date());
            orderSender.send(message);
        }

        logger.info("Waiting for all ActiveMQ JMS Messages to be consumed");
        TimeUnit.SECONDS.sleep(3);
        System.exit(-1);
    }
}
