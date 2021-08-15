package edu.hue.springclou.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import edu.hue.springclou.service.HystrixPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 47552
 * @date 2021/08/09
 */
@RestController
@DefaultProperties(defaultFallback = "Global_FallBack")
public class HystrixOrderController {

    @Autowired
    private HystrixPaymentService hystrixPaymentService;

    @GetMapping("/order/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return hystrixPaymentService.paymentInfo_OK(id);
    }

    @GetMapping("/order/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2100")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int age = 10/0;
        return hystrixPaymentService.paymentInfo_TimeOut(id);
    }
    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id) {
        return "我是消费者80，抱歉，当前系统繁忙，请稍后再试！";
    }

    public String Global_FallBack(){
        return "我是Global_FallBack，当前系统繁忙，请稍后再试！";
    }
}
