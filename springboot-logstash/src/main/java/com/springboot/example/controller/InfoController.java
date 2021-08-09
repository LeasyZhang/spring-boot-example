package com.springboot.example.controller;

import com.springboot.example.exception.CustomException;
import com.springboot.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@RestController
public class InfoController {

    private final Logger logger = LoggerFactory.getLogger(InfoController.class);

    @RequestMapping("/info")
    public String info() {
        String accessLog = "Access Info Controller at : " + Instant.now().toString();

        User user = new User();
        user.setId(31L);
        user.setName("joe.zhang");

        logger.info("{} log message {}", keyValue("user", user), accessLog);
        //logger.info(new Gson().toJson(user));
        String response = "detailed info";
        return response;
    }

    @RequestMapping("/exception")
    public String exception() {
        throw new CustomException();
    }
}
