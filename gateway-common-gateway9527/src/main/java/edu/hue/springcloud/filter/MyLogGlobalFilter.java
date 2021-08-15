package edu.hue.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author 47552
 * @date 2021/08/10
 */
@Component
@Slf4j
public class MyLogGlobalFilter implements GlobalFilter, Ordered {

    /**
     * exchange：封装了 Request、Response
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("=============进入 MyLogGlobalFilter，time：{} =============",new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        //如果是非法用户
        if (username == null) {
            log.info("=============用户名为:null，非法用户 =============");
            //告诉客户端，此请求不被接受
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //指示请求已处理完成
            exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
