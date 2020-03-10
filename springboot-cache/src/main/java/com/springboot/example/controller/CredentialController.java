package com.springboot.example.controller;

import com.springboot.example.model.Credential;
import com.springboot.example.service.CredentialService;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class CredentialController {

    private CredentialService credentialService;
    private CacheManager cacheManager;

    public CredentialController(CredentialService credentialService, CacheManager cacheManager) {
        this.credentialService = credentialService;
        this.cacheManager = cacheManager;
    }

    @GetMapping("/credential/{username}/{type}")
    public Credential getCredential(@PathVariable(value = "username") String username,
                                    @PathVariable(value = "type") String type) {
        return credentialService.findCredential(username, type);
    }

    @GetMapping("/cache/stat")
    public List<String> getStats() {
        List<String> statList = new ArrayList<>();
        Collection<String> cacheNameList = cacheManager.getCacheNames();
        if (CollectionUtils.isEmpty(cacheNameList)) {
            return statList;
        }
        cacheNameList.stream().forEach(cacheName -> {
            CaffeineCache caffeineCache = (CaffeineCache) cacheManager.getCache(cacheName);
            System.out.println(caffeineCache.getNativeCache().stats());
            statList.add(caffeineCache.getNativeCache().stats().toString());
        });
        return statList;
    }
}
