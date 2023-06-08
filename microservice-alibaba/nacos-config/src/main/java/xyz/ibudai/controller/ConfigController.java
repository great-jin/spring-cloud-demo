package xyz.ibudai.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/config")
public class ConfigController {

    @Value("${info.name}")
    private String name;

    @GetMapping("/demo")
    public String demo() {
        return name;
    }
}
