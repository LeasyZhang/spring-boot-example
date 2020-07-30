package com.springboot.exmaple.interceptor;

import com.springboot.exmaple.exception.RetryException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @AfterThrowing(pointcut = "execution(* com.springboot.exmaple.service.*.retryAction(..)) && @annotation(monitor)", throwing = "error")
    public void logException(LogMonitor monitor, Throwable error) {
        if (error instanceof RetryException) {
            logger.error("Retry exception", error);
        }
    }
}
