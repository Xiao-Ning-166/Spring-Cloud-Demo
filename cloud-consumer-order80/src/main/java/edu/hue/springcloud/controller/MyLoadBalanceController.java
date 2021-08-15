package edu.hue.springcloud.controller;

import edu.hue.springcloud.entity.CommonResult;
import edu.hue.springcloud.entity.Payment;
import edu.hue.springcloud.lb.MyLoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author 47552
 * @date 2021/08/09
 */
@RestController
@Slf4j
public class MyLoadBalanceController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MyLoadBalance myLoadBalance;

    @Autowired
    private DiscoveryClient discoveryClient;

    private String PAYMENT_NAME = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/order/myLoadBalance/{id}")
    public CommonResult<Payment> myLoadBalance(@PathVariable("id") Long id) {
        //得到指定服务的总实例数
        List<ServiceInstance> serviceInstances =
                discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        //判断实例集合是否可用
        if (serviceInstances == null || serviceInstances.size() <= 0) {
            return null;
        }
        //得到本次请求的实例
        ServiceInstance serviceInstance =
                myLoadBalance.serviceInstance(serviceInstances);
        //得到请求地址
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/get/"+id,CommonResult.class);
    }

}
