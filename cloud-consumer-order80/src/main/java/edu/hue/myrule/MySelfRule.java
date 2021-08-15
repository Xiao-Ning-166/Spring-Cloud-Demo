package edu.hue.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 47552
 * @date 2021/08/09
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        //指定规则，例如：随机
        return new RandomRule();
    }

}
