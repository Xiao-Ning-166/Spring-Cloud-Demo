package edu.hue.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 47552
 * @date 2021/08/14
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SentinelOrder83 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelOrder83.class,args);
    }
}
