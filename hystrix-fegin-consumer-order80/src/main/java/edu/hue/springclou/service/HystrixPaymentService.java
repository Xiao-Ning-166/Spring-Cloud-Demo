package edu.hue.springclou.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 47552
 * @date 2021/08/09
 */
@FeignClient(value = "HYSTRIX-PROVIDER-PAYMENT",fallback = HystrixPaymentFallBackService.class)
public interface HystrixPaymentService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}
