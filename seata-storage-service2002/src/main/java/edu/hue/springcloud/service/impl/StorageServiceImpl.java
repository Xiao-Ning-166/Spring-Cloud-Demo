package edu.hue.springcloud.service.impl;

import edu.hue.springcloud.dao.StorageDao;
import edu.hue.springcloud.domian.CommonResult;
import edu.hue.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 47552
 * @date 2021/08/15
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void updateStorage(Long productId, Integer count) {
        storageDao.updateStorage(productId,count);
        log.info("============修改库存完成 StorageServiceImpl ============");
    }
}
