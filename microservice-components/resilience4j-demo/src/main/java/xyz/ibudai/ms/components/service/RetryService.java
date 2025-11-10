package xyz.ibudai.ms.components.service;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RetryService {

    @Retry(name = "test-retry", fallbackMethod = "fallback")
    public String callRetry() {
        return "success on " + System.currentTimeMillis();
    }

    public String fallback(Throwable t) {
        return String.format("Fallback msg: %s", t.getMessage());
    }
}
