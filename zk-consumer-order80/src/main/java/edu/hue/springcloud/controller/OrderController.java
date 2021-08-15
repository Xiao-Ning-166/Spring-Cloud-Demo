package edu.hue.springcloud.controller;

import edu.hue.springcloud.entity.CommonResult;
import edu.hue.springcloud.entity.Payment;
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

    @Autowired
    private RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://zk-payment-service";

    @GetMapping("/order/payment/zk")
    public String paymentInfo() {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }

}
