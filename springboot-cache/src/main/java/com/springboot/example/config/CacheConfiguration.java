package com.springboot.example.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private static final int DEFAULT_TTL = 3600;
    private static final int INIT_SIZE = 1000;
    private static final int MAX_SIZE = 10000;

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCacheNames(Arrays.asList("credential"));
        cacheManager.setCaffeine(credentialCacheBuilder());
        return cacheManager;
    }

    Caffeine<Object, Object> credentialCacheBuilder() {
        return Caffeine.newBuilder()
                .initialCapacity(INIT_SIZE)
                .maximumSize(MAX_SIZE)
                .expireAfterAccess(DEFAULT_TTL, TimeUnit.SECONDS)
                .recordStats();
    }
}
