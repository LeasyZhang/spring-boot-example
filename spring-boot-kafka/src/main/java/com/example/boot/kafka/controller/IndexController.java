package com.example.boot.kafka.controller;

import com.example.boot.kafka.service.KafkaSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    private final KafkaSenderService kafkaSenderService;

    @Autowired
    public IndexController(KafkaSenderService kafkaSenderService) {
        this.kafkaSenderService = kafkaSenderService;
    }

    @GetMapping("index")
    public String index() {
        kafkaSenderService.sendMessages("Access index controller", "access-api");
        return "access index";
    }
}
