package com.springboot.example.service;

import com.springboot.example.model.Credential;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@CacheConfig(cacheNames = "credential")
public class CredentialService {

    private static final Logger log = LoggerFactory.getLogger(CredentialService.class);

    private static final String SEPERATOR = ":";

    private static final Map<String, Credential> credentialMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        Credential credentialA = new Credential("typeA", "userA", "codeA");
        Credential credentialB = new Credential("typeB", "userB", "codeB");

        credentialMap.put("userA:typeA", credentialA);
        credentialMap.put("userB:typeB", credentialB);
    }

    @Cacheable(key = "#username.concat(':').concat(#type)", sync = true)
    public Credential findCredential(String username, String type) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Query from database");
        return credentialMap.get(username + ":" + type);
    }

    @CacheEvict(key = "#username+#SEPERATOR+#type")
    public void updateCredential(String username, String type) {
        String key = username + ":" + type;
        Credential cre = credentialMap.get(key);
        cre.setCredential(cre.getCredential() + Instant.now().toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        credentialMap.put(key, cre);
    }

    @CacheEvict(allEntries = true)
    public void truncateCredential() {

    }

    @CachePut(key = "#username+#SEPERATOR+#type")
    public Credential addCredential(String username, String type, String credential) {
        String key = username + ":" + type;
        Credential credential1 = new Credential(username, type, credential);
        credentialMap.put(key, credential1);
        return credential1;
    }
}
