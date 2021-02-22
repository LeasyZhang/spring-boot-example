package example.boot.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RetryBusinessService {

    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 1000))
    public void retry() {
        log.info("[retry] method is called");
        throw new CustomException("Retry failed");
    }
}
