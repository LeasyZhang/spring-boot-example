package com.springboot.example.controller;

import com.springboot.example.model.Config;
import com.springboot.example.service.ConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    private ConfigService configService;

    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping("/config/{key}")
    public ResponseEntity<Config> getConfig(@PathVariable("key") String key) {
        return ResponseEntity.ok(configService.findConfigByKey(key));
    }

}
