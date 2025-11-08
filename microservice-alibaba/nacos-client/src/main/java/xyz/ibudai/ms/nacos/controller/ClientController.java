package xyz.ibudai.ms.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @GetMapping("/demo")
    public String demo() {
        return "Hello world!";
    }
}
