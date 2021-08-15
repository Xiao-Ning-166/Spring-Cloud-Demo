package edu.hue.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author 47552
 * @date 2021/08/09
 */
public interface MyLoadBalance {

    ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances);
}
