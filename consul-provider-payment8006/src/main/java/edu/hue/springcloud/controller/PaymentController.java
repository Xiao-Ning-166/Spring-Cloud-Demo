package edu.hue.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 47552
 * @date 2021/08/08
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    public String serverPort;

    @GetMapping("/payment/consul")
    public String paymentConsul() {
        return "spring cloud with consul："+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
