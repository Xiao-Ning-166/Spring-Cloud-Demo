package edu.hue.springcloud.controller;

import edu.hue.springcloud.domian.CommonResult;
import edu.hue.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author 47552
 * @date 2021/08/15
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/update")
    public CommonResult updateAccount(@RequestParam("userId") Long userId,
                               @RequestParam("money") BigDecimal money){
        accountService.updateAccount(userId,money);
        return new CommonResult(200,"账户余额更新成功！");
    }
}
