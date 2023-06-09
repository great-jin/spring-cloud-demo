package xyz.ibudai.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("nacos-config")
public interface FeignService {

    @GetMapping("/api/config/config")
    String getConfigName();

    @GetMapping("/api/config/common")
    String getCommonName();
}
