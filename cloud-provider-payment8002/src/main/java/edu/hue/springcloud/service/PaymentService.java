package edu.hue.springcloud.service;

import edu.hue.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 47552
 * @date 2021/08/07
 */
public interface PaymentService {

    /**
     * 新增一条记录
     */
    public int add(Payment payment);

    /**
     * 通过 id 获取记录
     */
    public Payment getPaymentById(@Param("id") Long id);
}
