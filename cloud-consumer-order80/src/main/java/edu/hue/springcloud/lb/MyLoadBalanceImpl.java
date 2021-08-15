package edu.hue.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 47552
 * @date 2021/08/09
 */
@Component
public class MyLoadBalanceImpl implements MyLoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances) {
        //轮询
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    //得到当前请求是第几次
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current+1;
        } while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("============next：" + next + "========================");
        return next;
    }
}
