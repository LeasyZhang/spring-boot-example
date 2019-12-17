package com.springboot.example.controller;

import com.google.gson.Gson;
import com.springboot.example.model.Ting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class TingController {

    private final Logger logger = LoggerFactory.getLogger(TingController.class);

    @RequestMapping("/ting")
    public Ting ting() {
        Ting data = new Ting();

        data.setTag("Ting");
        data.setCount(12);
        data.setTimestamp(Instant.now());

        logger.info("Access Ting Controller at " + Instant.now());
        logger.info("{}", new Gson().toJson(data));

        return data;
    }
}
