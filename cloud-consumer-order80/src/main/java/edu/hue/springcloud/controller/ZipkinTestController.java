package edu.hue.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 47552
 * @date 2021/08/11
 */
@RestController
public class ZipkinTestController {

    @Autowired
    private RestTemplate restTemplate;

    private String PAYMENT_NAME = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/order/zipkin")
    public String zipkinTest() {
        return restTemplate.getForObject(PAYMENT_NAME+"/payment/zipkin",String.class);
    }

}
