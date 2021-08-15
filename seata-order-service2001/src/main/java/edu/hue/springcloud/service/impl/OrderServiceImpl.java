package edu.hue.springcloud.service.impl;

import edu.hue.springcloud.dao.OrderDao;
import edu.hue.springcloud.domian.Order;
import edu.hue.springcloud.service.AccountService;
import edu.hue.springcloud.service.OrderService;
import edu.hue.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 47552
 * @date 2021/08/15
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    /**
     * 流程：创建订单 --> 减库存 --> 扣余额 --> 修改订单状态
     */
    @Override
    //Seata 分布式事务
    @GlobalTransactional(name = "fsp_tx_group",rollbackFor = Exception.class)
    public void createOrder(Order order) {
        //1、新建订单
        log.info("==========创建订单==========");
        orderDao.createOrder(order);

        //2、扣减库存
        log.info("==========订单微服务，调用库存，做扣减(count)==========");
        storageService.updateStorage(order.getProductId(),order.getCount());

        //3、扣减余额
        log.info("==========订单微服务，调用账户，扣减余额(money)==========");
        accountService.updateAccount(order.getUserId(),order.getMoney());

        //4、修改订单状态。表示已完成
        log.info("==========修改订单状态==========");
        orderDao.updateOrder(order.getUserId(),0);

    }

    @Override
    public void updateOrder(Long userId, Integer status) {
        orderDao.updateOrder(userId,status);
    }
}
