package example.boot.api;

import example.boot.retry.RetryBusinessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retry")
public class RetryApi {

    private RetryBusinessService retryBusinessService;

    public RetryApi(RetryBusinessService retryBusinessService) {
        this.retryBusinessService = retryBusinessService;
    }

    @GetMapping
    public ResponseEntity<String> callRetry() {
        retryBusinessService.retry();
        return ResponseEntity.ok("Impossible");
    }
}
