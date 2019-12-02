package com.springboot.exmaple.api;

import com.google.gson.Gson;
import com.springboot.exmaple.dto.HealthCheckResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthCheckController {

    @GetMapping("/status")
    public String status() {
        HealthCheckResponse response = new HealthCheckResponse(200, "OK");
        return new Gson().toJson(response);
    }
}
