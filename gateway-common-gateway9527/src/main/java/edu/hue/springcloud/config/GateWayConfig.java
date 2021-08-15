package edu.hue.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 47552
 * @date 2021/08/10
 */
@Configuration
public class GateWayConfig {

    /**
     * 配置了一个id为path_route01的路由规则
     * 当访问 http://localhost:9527/guonei时，会自动转发到地址：http://news.baidu.com/guonei
     */
    @Bean
    public RouteLocator MyRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route01",
                p -> p.path("/guonei").
                        uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }

}
