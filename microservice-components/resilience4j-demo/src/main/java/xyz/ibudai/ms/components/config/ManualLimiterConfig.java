package xyz.ibudai.ms.components.config;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManualLimiterConfig {

    @Bean
    public RateLimiterRegistry rateLimiterRegistry() {
        RateLimiterConfig defaultConfig = RateLimiterConfig.custom()
                .build();
        return RateLimiterRegistry.of(defaultConfig);
    }

    @Bean
    public RateLimiter manualRateLimiter(RateLimiterRegistry rateLimiterRegistry) {
        RateLimiterConfig config = RateLimiterConfig.from(rateLimiterRegistry.getDefaultConfig())
                .build();
        return rateLimiterRegistry.rateLimiter("manual-limiter", config);
    }
}
