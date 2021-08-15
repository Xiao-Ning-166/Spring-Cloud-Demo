package edu.hue.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import edu.hue.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 47552
 * @date 2021/08/09
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问，没问题的方法
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池："+Thread.currentThread().getName()+"，paymentInfo_OK，id："+id;
    }


    /**
     * 因为超时出错的方法
     */
    @Override
    /**
     * fallbackMethod：备用方法
     * execution.isolation.thread.timeoutInMilliseconds：设置自身调用超时时间的峰值
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3100")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int time = 1;
//        int i = 10 / 0;
//        try {
//            TimeUnit.MILLISECONDS.sleep(time*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "线程池："+Thread.currentThread().getName()+"，paymentInfo_TimeOut，id："+id+"，耗时："+time+"秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池："+Thread.currentThread().getName()+"，8001系统出错或繁忙，id："+id;
    }


    /**
     * 服务熔断
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_FallBack",commandProperties = {
            //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            //请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            //时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
            //总的意思：在 时间窗口期内，如果 请求次数 的失败率到指定后，访问不好使
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("========id不能为负数=======");
        }
        String serialNum = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"，调用成功，流水号："+serialNum;
    }
    public String paymentCircuitBreaker_FallBack(Integer id) {
        return "id不能为负数，请重试！";
    }

}
