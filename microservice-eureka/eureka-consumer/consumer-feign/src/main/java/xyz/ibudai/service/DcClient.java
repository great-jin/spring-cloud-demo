package xyz.ibudai.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("client-1")
public interface DcClient {

    @GetMapping("/api/client/dc")
    String consumer();

}
