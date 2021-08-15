package edu.hue.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 47552
 * @date 2021/08/12
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos")
    public String NacosTest() {
        return "Hello Nacos，My port is："+serverPort;
    }

}
