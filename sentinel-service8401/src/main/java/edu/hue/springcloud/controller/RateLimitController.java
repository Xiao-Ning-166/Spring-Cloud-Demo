package edu.hue.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import edu.hue.springcloud.entity.CommonResult;
import edu.hue.springcloud.entity.Payment;
import edu.hue.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 47552
 * @date 2021/08/13
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200,"按资源名称限流测试ok",new Payment(2020L,"serial001"));
    }
    /**
     * byResource 的兜底方法
     */
    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName()+" 服务不可用");
    }

    /**
     * 测试按照资源 url 限流
     */
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200,"按资源Url限流测试ok",
                new Payment(2020L,"serial002"));
    }

    /**
     * value：资源名，唯一表示
     * blockHandlerClass：兜底方法所在类
     * blockHandler：兜底方法名称
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException01")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200,"测试客户自定义限流处理逻辑",
                new Payment(2020L,"serial003"));
    }
}
