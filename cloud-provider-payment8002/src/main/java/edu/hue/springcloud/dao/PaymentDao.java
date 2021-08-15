package edu.hue.springcloud.dao;

import edu.hue.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 47552
 * @date 2021/08/07
 */
@Mapper
public interface PaymentDao {

    /**
     * 新增一条记录
     */
    public int add(Payment payment);

    /**
     * 通过 id 获取记录
     */
    public Payment getPaymentById(@Param("id") Long id);
}
