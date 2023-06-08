package xyz.ibudai.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("client-1")
public interface FeignService {

    @GetMapping("/api/client/getServices")
    String getServices();

}
