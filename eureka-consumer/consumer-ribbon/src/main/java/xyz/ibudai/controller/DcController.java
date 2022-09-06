package xyz.ibudai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/service2")
public class DcController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 消费者 consumer-1 通过服务中心请求 client-1 接口
     */
    @GetMapping("/consumer")
    public String dc() {
        return restTemplate.getForObject("http://client-1/api/service1/dc",
                String.class);
    }
}
