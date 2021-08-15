package edu.hue.springcloud.service;

import edu.hue.springcloud.domian.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 47552
 * @date 2021/08/15
 */
public interface StorageService {

    /**
     * 根据 产品id、购买数量更新 库存
     */
     void updateStorage(@RequestParam("productId") Long productId,
                        @RequestParam("count") Integer count);
}
