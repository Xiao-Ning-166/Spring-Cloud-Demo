package edu.hue.springcloud.service;

import edu.hue.springcloud.domian.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 47552
 * @date 2021/08/15
 */
@Component
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 根据产品id，操作库存微服务，减少库存
     */
    @PostMapping("/storage/update")
    CommonResult updateStorage(@RequestParam("productId") Long productId,
                                 @RequestParam("count") Integer count);

}
