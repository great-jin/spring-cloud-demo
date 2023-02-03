package xyz.ibudai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/ribbon/consumer")
public class DcController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 消费者通过服务中心请求 client 接口
     */
    @GetMapping("/get")
    public String get() {
        // Spring Cloud Ribbon 有一个拦截器能够在实际调用的时候自动的去选取服务实例，
        // 并将实际要请求的 IP 地址和端口替换这里的服务名，从而完成服务接口的调用。
        String url = "http://client-1/api/client1/dc";
        return restTemplate.getForObject(url, String.class);
    }
}
