package com.springboot.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class InfoController {

    private final Logger logger = LoggerFactory.getLogger(InfoController.class);

    @RequestMapping("/info")
    public String info() {
        String accessLog = "Access to info controller at" + Instant.now().toString();
        logger.info(accessLog);

        String response = "detailed info";
        return response;
    }

    @RequestMapping("/exception")
    public String exception() {
        String response = "500 internal error";
        try {
            throw new Exception("woops!");
        }catch (Exception e) {
            logger.error("Got error while access exception controller", e);
        }
        return response;
    }
}
