package com.springboot.example.service;

import com.springboot.example.model.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * If we don't configure config in cache config, the access to ConfigService will throw error.
 */
@Service
@CacheConfig(cacheNames = "config")
public class ConfigService {

    private static final Logger logger = LoggerFactory.getLogger(ConfigService.class);

    private final Map<String, String> config = new HashMap<>();

    @Cacheable(key = "#key")
    public Config findConfigByKey(String key) {
        logger.info("perform time consuming operation");
        Config conf = new Config();
        conf.setKey(key);
        conf.setValue(config.get(key));
        return conf;
    }

    @PostConstruct
    public void addData() {
        config.put("key","value");
    }
}
