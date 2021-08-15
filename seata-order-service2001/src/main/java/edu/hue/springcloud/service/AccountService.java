package edu.hue.springcloud.service;

import edu.hue.springcloud.domian.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author 47552
 * @date 2021/08/15
 */
@Component
@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 调用 账户微服务，修改 账户余额
     */
    @PostMapping("/account/update")
    CommonResult updateAccount(@RequestParam("userId") Long userId,
                               @RequestParam("money") BigDecimal money);

}
