package xyz.ibudai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.ibudai.filter.WebFilter;

@Configuration
public class FilterConfig {

    @Bean
    public WebFilter webFilter() {
        return new WebFilter();
    }
}
