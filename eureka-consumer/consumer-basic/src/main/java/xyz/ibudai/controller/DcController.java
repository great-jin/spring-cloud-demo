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
     * Spring Cloud 原生负载均衡客户端
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 消费者 service-2 通过服务中心请求 service-1 接口
     */
    @GetMapping("/consumer")
    public String dc() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("child-service-1");
        String url = "http://" + serviceInstance.getHost() + ":"
                + serviceInstance.getPort()
                + "api/service1/dc";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
