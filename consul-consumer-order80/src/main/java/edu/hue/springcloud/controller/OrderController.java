package edu.hue.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 47552
 * @date 2021/08/08
 */
@RestController
@Slf4j
public class OrderController {

    public static final String CONSUL_PAYMENT_URL = "http://consul-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/consul")
    public String orderConsul() {
        return restTemplate.getForObject(CONSUL_PAYMENT_URL+"/payment/consul",String.class);
    }
}
