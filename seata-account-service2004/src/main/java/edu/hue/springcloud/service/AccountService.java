package edu.hue.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author 47552
 * @date 2021/08/15
 */
public interface AccountService {
    /**
     * 根据用户id，和使用金额 更新用户余额
     */
    void updateAccount(@RequestParam("userId") Long userId,
                       @RequestParam("money") BigDecimal money);
}
