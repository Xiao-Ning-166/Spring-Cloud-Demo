package edu.hue.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 47552
 * @date 2021/08/11
 */
@RestController
public class ZipkinTestController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zipkin")
    public String zipkinTest() {
        return serverPort;
    }

}
