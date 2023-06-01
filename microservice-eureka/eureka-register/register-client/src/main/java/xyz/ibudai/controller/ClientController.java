package xyz.ibudai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * 打印出服务实例的相关内容
     * <p>
     * Services: [clint-1, client-2]
     */
    @GetMapping("/dc")
    public String getServices() {
        return "Services: " + discoveryClient.getServices();
    }
}
