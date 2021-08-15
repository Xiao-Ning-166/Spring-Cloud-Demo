package edu.hue.springcloud.service;

import edu.hue.springcloud.entity.CommonResult;
import edu.hue.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author 47552
 * @date 2021/08/14
 * @FeginClient所在接口的兜底方法类
 */
@Component
public class MyPaymentFallBackService implements PaymentFallBackService {

    @Override
    public CommonResult<Payment> payment(Long id) {
        return new CommonResult<>(444,"服务降级返回  ----MyPaymentFallBackService",
                new Payment(id,null));
    }

}
