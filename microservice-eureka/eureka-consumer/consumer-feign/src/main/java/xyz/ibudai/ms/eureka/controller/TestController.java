package xyz.ibudai.ms.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ibudai.ms.eureka.service.FeignService;

@RestController
@RequestMapping("api/feign/consumer")
public class TestController {

    @Autowired
    FeignService feignService;

    @GetMapping("/get")
    public String get() {
        return feignService.getServices();
    }
}
