package edu.hue.springcloud.controller;

import edu.hue.springcloud.entity.CommonResult;
import edu.hue.springcloud.entity.Payment;
import edu.hue.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 47552
 * @date 2021/08/07
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 服务发现
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/discoveryClient")
    public Object discoveryClient(){
        //得到所有的微服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("###########service：{}###########",service);
        }
        //得到指定微服务的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("###########微服务的id：{}，微服务的主机名：{}，微服务的端口号：{}###########",
                    instance.getServiceId(),instance.getHost(),instance.getPort());
        }
        return this.discoveryClient;
    }

    @PostMapping("/payment/add")
    public CommonResult add(@RequestBody Payment payment) {
        int res = paymentService.add(payment);
        log.info("********插入结果：{}*********",res);
        if (res > 0) {
            return new CommonResult(200,"插入数据成功！serverPort："+serverPort);
        } else {
            return new CommonResult(400,"插入数据失败！serverPort："+serverPort);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果：{}*********",payment);
        if (payment != null) {
            return new CommonResult<Payment>(200,"查询数据成功！serverPort："+serverPort,payment);
        } else {
            return new CommonResult<Payment>(400,"查询数据失败！serverPort："+serverPort);
        }
    }

    @GetMapping("/payment/gateway/{id}")
    public String getGateway(@PathVariable("id") Long id) {
        return "我使用了网关！id："+id;
    }

}
