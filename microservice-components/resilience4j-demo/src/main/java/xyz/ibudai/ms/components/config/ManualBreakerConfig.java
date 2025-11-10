package xyz.ibudai.ms.components.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManualBreakerConfig {

    @Bean
    public CircuitBreakerRegistry circuitBreakerRegistry() {
        CircuitBreakerConfig defaultConfig = CircuitBreakerConfig.custom()
                .build();
        return CircuitBreakerRegistry.of(defaultConfig);
    }


    @Bean
    public CircuitBreaker manualBreaker(CircuitBreakerRegistry circuitBreakerRegistry) {
        CircuitBreakerConfig config = CircuitBreakerConfig.from(circuitBreakerRegistry.getDefaultConfig())
                .build();
        return circuitBreakerRegistry.circuitBreaker("manual-breaker", config);
    }
}
