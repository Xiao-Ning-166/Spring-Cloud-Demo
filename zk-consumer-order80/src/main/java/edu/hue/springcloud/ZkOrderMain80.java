package edu.hue.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 47552
 * @date 2021/08/08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ZkOrderMain80.class,args);
    }
}
