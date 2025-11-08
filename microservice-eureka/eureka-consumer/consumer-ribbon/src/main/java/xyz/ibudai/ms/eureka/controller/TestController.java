package xyz.ibudai.ms.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/ribbon/consumer")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 消费者通过服务中心请求 client 接口
     * <p>
     * client-1: /api/client/dc
     */
    @GetMapping("/get")
    public String get() {
        // 无需类似 basic 中手动负载均衡
        String url = "http://client-1/api/client/getServices";
        return restTemplate.getForObject(url, String.class);
    }
}
