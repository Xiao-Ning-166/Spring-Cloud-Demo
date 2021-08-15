package edu.hue.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 47552
 * @date 2021/08/13
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String URI = "http://sentinel-service8401";

    @GetMapping("/order/testA")
    public String test01(){
        return restTemplate.getForObject(URI+"/testA",String.class);
    }

    @GetMapping("/order/testB")
    public String test02(){
        return restTemplate.getForObject(URI+"/testA",String.class);
    }
}
