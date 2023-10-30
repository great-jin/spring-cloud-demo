package xyz.ibudai.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HystrixService {

    @Autowired
    private FeignService feignService;

    /**
     * <a href="https://github.com/Netflix/Hystrix/wiki/Configuration}">Hystrix Configuration</a>
     */
    @HystrixCommand(
            commandProperties = {
                    // Timeout strategy, default value: true, 1000
                    @HystrixProperty(name = "execution.timeout.enabled", value = "true"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "10"),
                    @HystrixProperty(name = "maxQueueSize", value = "20"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "600")
            },
            // The "fallbackMethod" must have same parameter
            fallbackMethod = "fallback")
    public String getServices(boolean sleep) {
        return feignService.getServices(sleep);
    }

    public String fallback(boolean sleep) {
        return "failed!";
    }

}
