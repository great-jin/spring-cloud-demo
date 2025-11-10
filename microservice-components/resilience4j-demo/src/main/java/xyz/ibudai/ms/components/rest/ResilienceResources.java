package xyz.ibudai.ms.components.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.ibudai.ms.components.service.BreakerService;
import xyz.ibudai.ms.components.service.BulkHeadService;
import xyz.ibudai.ms.components.service.LimiterService;
import xyz.ibudai.ms.components.service.RetryService;

import javax.annotation.Resource;

@Resource
@RequestMapping("/api/resilience")
@RequiredArgsConstructor
public class ResilienceResources {

    private final RetryService retryService;
    private final LimiterService limiterService;
    private final BulkHeadService bulkHeadService;
    private final BreakerService breakerService;


    @GetMapping("callRetry")
    public String callRetry() {
        return retryService.callRetry();
    }

    @GetMapping("callLimit")
    public String callLimit() {
        return limiterService.callLimit();
    }

    @GetMapping("callBulk")
    public String callBulk() {
        return bulkHeadService.callBulk();
    }

    @GetMapping("callBreaker")
    public String callBreaker() {
        return breakerService.callBreaker();
    }
}
