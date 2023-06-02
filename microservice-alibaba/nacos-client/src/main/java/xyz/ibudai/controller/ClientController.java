package xyz.ibudai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @GetMapping("/demo")
    public String getServices() {
        return "Hello world!";
    }
}
