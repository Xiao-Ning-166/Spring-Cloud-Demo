package edu.hue.springcloud.controller;

import edu.hue.springcloud.entity.CommonResult;
import edu.hue.springcloud.entity.Payment;
import edu.hue.springcloud.service.PaymentFallBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 47552
 * @date 2021/08/14
 */
@RestController
public class FeignController {

    @Autowired
    private PaymentFallBackService paymentService;

    @GetMapping("/order/feign/{id}")
    public CommonResult<Payment> payment(@PathVariable("id") Long id){
        return paymentService.payment(id);
    }
}
