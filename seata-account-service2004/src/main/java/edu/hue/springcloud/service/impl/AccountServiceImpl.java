package edu.hue.springcloud.service.impl;

import edu.hue.springcloud.dao.AccountDao;
import edu.hue.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author 47552
 * @date 2021/08/15
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void updateAccount(Long userId, BigDecimal money) {
        //模拟异常，全局事务回滚
        int age = 10 / 0;
        accountDao.updateAccount(userId,money);
        log.info("=============账户更新完成！============");
    }
}
