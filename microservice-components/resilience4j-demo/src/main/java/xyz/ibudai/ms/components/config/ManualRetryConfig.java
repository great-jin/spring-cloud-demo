package xyz.ibudai.ms.components.config;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class ManualRetryConfig {

    @Bean
    public RetryRegistry retryRegistry() {
        RetryConfig defaultConfig = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofSeconds(1))
                .retryExceptions(RuntimeException.class)
                .build();
        return RetryRegistry.of(defaultConfig);
    }

    @Bean
    public Retry manualRetry(RetryRegistry retryRegistry) {
        RetryConfig config = RetryConfig.from(retryRegistry.getDefaultConfig())
                .maxAttempts(5)
                .waitDuration(Duration.ofMillis(500))
                .build();
        return retryRegistry.retry("manualRetry", config);
    }
}
