package edu.hue.springcloud.service;

import edu.hue.springcloud.entity.CommonResult;
import edu.hue.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 47552
 * @date 2021/08/14
 */
@FeignClient(value = "sentinel-provider-service",
        fallback = MyPaymentFallBackService.class)  //指定异常时，兜底方法所在类
public interface PaymentFallBackService {

    @GetMapping("/payment/{id}")    //要调用的方法的地址
    public CommonResult<Payment> payment(@PathVariable("id") Long id);

}
