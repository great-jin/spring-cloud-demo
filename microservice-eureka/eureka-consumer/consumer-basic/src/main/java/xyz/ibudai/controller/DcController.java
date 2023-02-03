package xyz.ibudai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/basic/consumer")
public class DcController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Spring Cloud 原生负载均衡客户端
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 消费者通过服务中心请求 client 接口
     */
    @GetMapping("/get")
    public String dc() {
        // 通过负载均衡选择客户端实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("client-1");
        // 根据选择的实例拼接请求地址
        String url = "http://" + serviceInstance.getHost() + ":"
                + serviceInstance.getPort()
                + "/api/client/dc";
        System.out.println("Basic consumer url: " + url);
        // 通过 restTemplate 调用服务接口
        return restTemplate.getForObject(url, String.class);
    }
}
