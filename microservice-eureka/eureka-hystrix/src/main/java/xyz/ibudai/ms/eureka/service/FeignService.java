package xyz.ibudai.ms.eureka.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("client-1")
public interface FeignService {

    @GetMapping("/api/client/getServices")
    String getServices(@RequestParam(value = "sleep", required = false) boolean sleep);

}
