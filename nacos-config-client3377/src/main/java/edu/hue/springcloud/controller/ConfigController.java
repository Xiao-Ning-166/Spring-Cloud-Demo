package edu.hue.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 47552
 * @date 2021/08/12
 */
@RestController
@RefreshScope      //支持Nacos的动态刷新功能
public class ConfigController {

    @Value("${config.info}")
    private String configInfog;

    @GetMapping("/configInfo")
    public String configTest() {
        return configInfog;
    }
}
