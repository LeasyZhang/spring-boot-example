package example.ratelimit.interceptor;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Configuration
public class LimitAspect {

    private static final Logger logger = LoggerFactory.getLogger(LimitAspect.class);

    private RedisTemplate<String, Serializable> redisTemplate;
    private DefaultRedisScript<Number> redisScript;

    @Autowired
    public LimitAspect(RedisTemplate<String, Serializable> redisTemplate, DefaultRedisScript<Number> redisScript) {
        this.redisTemplate = redisTemplate;
        this.redisScript = redisScript;
    }

    @Around("execution(* example.ratelimit.controller ..*(..))")
    public Object intercept(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        RateLimit rateLimit = method.getAnnotation(RateLimit.class);

        if (rateLimit != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String ipAddress = getIpAddr(request);
            StringBuffer buffer = new StringBuffer();
            buffer.append(ipAddress).append("-")
                .append(targetClass.getName()).append("-")
                .append(method.getName()).append("-")
                .append(rateLimit.key());
            List<String> keys = Collections.singletonList(
                buffer.toString()
            );
            Number number = redisTemplate.execute(redisScript, keys, rateLimit.count(), rateLimit.time());
            if(number != null && number.intValue() != 0 && number.intValue() <= rateLimit.count()) {
                logger.info("Access {} times within ratelimit time window", number.intValue());
                return joinPoint.proceed();
            }
        } else {
            return joinPoint.proceed();
        }
        throw new RuntimeException("Exceed ratelimit");
    }

    private String getIpAddr(HttpServletRequest request) {
        String ipAddr;
        try {
            ipAddr = request.getHeader("x-forwarded-for");
            if(unknownAddr(ipAddr)) {
                ipAddr = request.getHeader("Proxy-Client-IP");
            }
            if(unknownAddr(ipAddr)) {
                ipAddr = request.getHeader("WL-Proxy-Client-IP");
            }
            if(unknownAddr(ipAddr)) {
                ipAddr = request.getRemoteAddr();
            }
            if(ipAddr != null && ipAddr.length() > 15) {
                if(ipAddr.indexOf(",") > 0) {
                    ipAddr = ipAddr.substring(0, ipAddr.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddr = "";
        }
        return ipAddr;
    }

    private boolean unknownAddr(String addr) {
        return StringUtils.isEmpty(addr) || addr.equalsIgnoreCase("unknown");
    }
}
