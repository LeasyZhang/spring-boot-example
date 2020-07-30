package com.springboot.exmaple.service;

import com.springboot.exmaple.exception.RetryException;
import com.springboot.exmaple.interceptor.LogMonitor;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class RetryService {

    private final AtomicLong counter = new AtomicLong(0);

    @LogMonitor(value = "retry action")
    @Retryable(value = RetryException.class, maxAttempts = 3, backoff = @Backoff(delay = 5000))
    public String retryAction() {
        if (counter.incrementAndGet() == 3) {
            counter.set(0);
            return "Success";
        } else {
            throw new RetryException();
        }
    }
}
