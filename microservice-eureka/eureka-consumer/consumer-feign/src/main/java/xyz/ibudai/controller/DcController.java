package xyz.ibudai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ibudai.service.DcClient;

@RestController
@RequestMapping("api/feign/consumer")
public class DcController {

    @Autowired
    DcClient dcClient;

    @GetMapping("/get")
    public String dc() {
        return dcClient.consumer();
    }
}
