package xyz.ibudai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ibudai.service.FeignService;

@RestController
@RequestMapping("/api/nacos/feign")
public class FeignController {

    @Autowired
    private FeignService feignService;

    @GetMapping("/config")
    public String getConfigName() {
        return feignService.getConfigName();
    }

    @GetMapping("/common")
    public String getCommonName() {
        return feignService.getCommonName();
    }

}
