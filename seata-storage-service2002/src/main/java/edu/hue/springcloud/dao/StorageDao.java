package edu.hue.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 47552
 * @date 2021/08/15
 */
@Mapper
public interface StorageDao {
    /**
     * 根据产品id，操作库存微服务，减少库存
     */
    void updateStorage(@Param("productId") Long productId,
                       @Param("count") Integer count);
}
