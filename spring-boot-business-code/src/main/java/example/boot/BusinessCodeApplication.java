package example.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

@EnableAspectJAutoProxy
@EnableRetry
@SpringBootApplication
public class BusinessCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessCodeApplication.class, args);
    }
}
