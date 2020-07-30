package com.springboot.exmaple.controller;

import com.springboot.exmaple.service.RetryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetryController {

    private RetryService retryService;

    public RetryController(RetryService retryService) {
        this.retryService = retryService;
    }

    @GetMapping("/retry")
    public String retryThreeTimes() {
        return retryService.retryAction();
    }

    @GetMapping("/success")
    public String success() {
        return "Hit once";
    }
}
