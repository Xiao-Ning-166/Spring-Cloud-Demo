package edu.hue.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author 47552
 * @date 2021/08/15
 */
@Mapper
public interface AccountDao {

    /**
     * 根据 用户id，更新 用户余额
     */
    void updateAccount(@Param("userId") Long userId,
                       @Param("money") BigDecimal money);
}
