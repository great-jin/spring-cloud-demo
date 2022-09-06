package xyz.ibudai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/service1")
public class TestController {

    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * 打印出服务实例的相关内容
     */
    @GetMapping("/dc")
    public String dcService() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
