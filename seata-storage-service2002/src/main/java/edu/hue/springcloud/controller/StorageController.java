package edu.hue.springcloud.controller;

import edu.hue.springcloud.domian.CommonResult;
import edu.hue.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 47552
 * @date 2021/08/15
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/update")
    CommonResult updateStorage(@RequestParam("productId") Long productId,
                               @RequestParam("count") Integer count) {
        storageService.updateStorage(productId,count);
        return new CommonResult(200,"更新库存完成！");
    }

}
