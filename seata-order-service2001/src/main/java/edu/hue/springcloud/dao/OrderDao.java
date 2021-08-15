package edu.hue.springcloud.dao;

import edu.hue.springcloud.domian.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 47552
 * @date 2021/08/15
 */
@Mapper
public interface OrderDao {

    /**
     * 创建一个订单
     */
    void createOrder(Order order);

    /**
     * 修改订单状态，从 0 --> 1
     */
    void updateOrder(@Param("userId") Long userId,@Param("status") Integer status);
}
