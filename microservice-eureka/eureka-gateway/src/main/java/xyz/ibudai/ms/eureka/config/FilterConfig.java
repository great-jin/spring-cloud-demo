package xyz.ibudai.ms.eureka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.ibudai.ms.eureka.filter.WebFilter;

@Configuration
public class FilterConfig {

    @Bean
    public WebFilter webFilter() {
        return new WebFilter();
    }
}
