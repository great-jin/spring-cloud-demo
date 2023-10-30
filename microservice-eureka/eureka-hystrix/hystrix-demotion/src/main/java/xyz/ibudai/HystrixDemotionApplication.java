package xyz.ibudai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixDemotionApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDemotionApplication.class, args);
    }

}
