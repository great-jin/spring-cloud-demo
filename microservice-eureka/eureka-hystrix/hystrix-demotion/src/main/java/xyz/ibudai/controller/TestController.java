package xyz.ibudai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ibudai.service.FeignService;
import xyz.ibudai.service.HystrixService;

@RestController
@RequestMapping("/api/hystrix")
public class TestController {

    @Autowired
    private FeignService feignService;

    @Autowired
    private HystrixService hystrixService;

    @GetMapping("/feignCall")
    public String feignCall(boolean sleep) {
        return feignService.getServices(sleep);
    }

    @GetMapping("/getServices")
    public String getServices(boolean sleep) {
        return hystrixService.getServices(sleep);
    }
}
