package edu.hue.springclou.service;

import org.springframework.stereotype.Component;

/**
 * @author 47552
 * @date 2021/08/10
 */
@Component
public class HystrixPaymentFallBackService implements HystrixPaymentService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "==================paymentInfo_OK，FallBack==================";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "==================paymentInfo_TimeOut，FallBack==================";
    }
}
