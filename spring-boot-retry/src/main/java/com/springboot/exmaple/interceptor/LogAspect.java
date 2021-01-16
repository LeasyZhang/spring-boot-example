package com.springboot.exmaple.interceptor;

import com.springboot.exmaple.exception.RetryException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @AfterThrowing(pointcut = "execution(* com.springboot.exmaple.service.*.retryAction(..)) && @annotation(monitor)", throwing = "error")
    public void logException(LogMonitor monitor, Throwable error) {
        if (error instanceof RetryException) {
            log.error("Retry exception", error);
        }
    }
}
