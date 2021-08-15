package edu.hue.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 47552
 * @date 2021/08/12
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-uri.payment-service}")
    private String paymentService;

    @GetMapping("/order/nacos")
    public String nacosTest(){
        return restTemplate.getForObject(paymentService+"/payment/nacos",String.class);
    }

}
