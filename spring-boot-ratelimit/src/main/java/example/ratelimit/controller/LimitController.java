package example.ratelimit.controller;


import example.ratelimit.interceptor.RateLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @RateLimit()
    @GetMapping("/limit")
    public String limitTest() {
        return "Success";
    }

    @RateLimit(key = "limit-b", time = 10, count = 10)
    @GetMapping("/limitB")
    public String limitTestB() {
        return "Limit test B";
    }
}
