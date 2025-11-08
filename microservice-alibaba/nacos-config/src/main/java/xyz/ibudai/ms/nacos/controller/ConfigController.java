package xyz.ibudai.ms.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/config")
public class ConfigController {

    @Value("${common.name}")
    private String commonName;

    @Value("${config.name}")
    private String configName;

    @GetMapping("/config")
    public String getConfigName() {
        return configName;
    }

    @GetMapping("/common")
    public String getCommonName() {
        return commonName;
    }
}
