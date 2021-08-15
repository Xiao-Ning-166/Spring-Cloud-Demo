package edu.hue.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author 47552
 * @date 2021/08/09
 */
public interface PaymentService {

    /**
     * 正常访问，没问题的方法
     */
    public String paymentInfo_OK(Integer id);

    /**
     * 因为超时出错的方法
     */
    public String paymentInfo_TimeOut(Integer id);

    /**
     * 服务熔断测试方法
     */
    public String paymentCircuitBreaker(Integer id);
}
