package xyz.ibudai.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/config/client")
public class TestController {

    @Value("${ibudai.name:default}")
    private String name;

    @GetMapping("/getInfo")
    public String getInfo() {
        return name;
    }
}
