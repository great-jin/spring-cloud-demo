package xyz.ibudai.ms.components.service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LimiterService {

    @RateLimiter(name = "test-limiter", fallbackMethod = "fallback")
    public String callLimit() {
        return "success on " + System.currentTimeMillis();
    }

    public String fallback(Throwable t) {
        return String.format("Fallback msg: %s", t.getMessage());
    }
}
