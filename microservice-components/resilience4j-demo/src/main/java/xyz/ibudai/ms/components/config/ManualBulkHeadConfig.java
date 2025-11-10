package xyz.ibudai.ms.components.config;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManualBulkHeadConfig {

    @Bean
    public BulkheadRegistry bulkheadRegistry() {
        BulkheadConfig defaultConfig = BulkheadConfig.custom()
                .build();
        return BulkheadRegistry.of(defaultConfig);
    }


    @Bean
    public Bulkhead manualBulkhead(BulkheadRegistry bulkheadRegistry) {
        BulkheadConfig config = BulkheadConfig.from(bulkheadRegistry.getDefaultConfig())
                .build();
        return bulkheadRegistry.bulkhead("manual-bulkhead", config);
    }
}
