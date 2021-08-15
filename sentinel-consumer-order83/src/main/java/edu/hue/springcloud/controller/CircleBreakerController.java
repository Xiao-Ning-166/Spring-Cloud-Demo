package edu.hue.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import edu.hue.springcloud.entity.CommonResult;
import edu.hue.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 47552
 * @date 2021/08/14
 */
@RestController
public class CircleBreakerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server-url.payment-service}")
    private String paymentUrl;

    @GetMapping("/order/fallback/{id}")
//    @SentinelResource(value = "fallback",
//            fallback = "fallbackBackups")   //备用方法名，负责业务异常
//    @SentinelResource(value = "fallback",
//            blockHandler = "fallbackBlockHandler")  //只负责 sentinel控制台的违规
    @SentinelResource(value = "fallback",
            fallback = "fallbackBackups",
            blockHandler = "fallbackBlockHandler")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(paymentUrl+"/payment/"+id,
                CommonResult.class,id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException 非法参数异常");
        } else if (result.getData() == null) {
            throw new NullPointerException("该 id 没有对应记录，空指针异常 NullPointerException");
        }
        return result;
    }
    public CommonResult<Payment> fallbackBlockHandler(@PathVariable("id") Long id,
                                                      BlockException exception) {
        return new CommonResult<Payment>(999,
                "sentinel配置了限流，目前无法访问，BlockException："+exception.getMessage(),
                    new Payment(id,null));
    }
    public CommonResult<Payment> fallbackBackups(@PathVariable("id") Long id,Throwable throwable) {
        return new CommonResult<Payment>(444,
                "只配置了 fallback，异常内容："+throwable.getMessage(),
                new Payment(id,null));
    }
}
