package xyz.ibudai.ms.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * 打印出服务实例的相关内容
     * <p>
     * Services: [clint-1, client-2]
     */
    @GetMapping("/getServices")
    public String getServices(@RequestParam(required = false) boolean sleep) {
        if (sleep) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        return "Services: " + discoveryClient.getServices();
    }
}
