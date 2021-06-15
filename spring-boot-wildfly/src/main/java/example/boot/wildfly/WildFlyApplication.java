package example.boot.wildfly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WildFlyApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WildFlyApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WildFlyApplication.class, args);
    }
}

@RestController
class HelloController {

    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        return String.format("Hello %s !", name);
    }
}
