package com.springboot.example.controller;

import com.google.gson.Gson;
import com.springboot.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

import static net.logstash.logback.argument.StructuredArguments.keyValue;
import static net.logstash.logback.marker.Markers.appendFields;

@RestController
public class InfoController {

    private final Logger logger = LoggerFactory.getLogger(InfoController.class);

    @RequestMapping("/info")
    public String info() {
        String accessLog = "Access to info controller at : " + Instant.now().toString();

        User user = new User();
        user.setId(31L);
        user.setName("joe.zhang");

        logger.info("{} log message {}", keyValue("user", user), accessLog);

        String response = "detailed info";
        return response;
    }

    @RequestMapping("/exception")
    public String exception() {
        String response = "500 internal error";

        User user = new User();
        user.setId(31L);
        user.setName("joe.zhang");

        try {
            throw new Exception("woops!");
        } catch (Exception e) {
            String jsonString = new Gson().toJson(user);
            logger.error(appendFields(user), "Got error while access exception controller");
        }
        return response;
    }
}
