package edu.hue.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 47552
 * @date 2021/08/13
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        log.info("============={}=============",Thread.currentThread().getName());
        return ".............testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return ".............testB";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "测试 慢调用";
    }

    @GetMapping("/testF")
    public String testE() {
        log.info("测试：异常数策略");
        int i = 10/0;
        return "测试：异常数策略";
    }

    @GetMapping("/hotkey")
    /**
     * value：资源名，唯一标识
     * blockHandler：违背在sentinel指定的规则时，执行的方法
     */
    @SentinelResource(value = "hotkey",blockHandler = "del_hotkey")
    public String hotKey(@RequestParam(value = "p1",required = false) String p1,
                         @RequestParam(value = "p2",required = false) String p2) {
        log.info("===============测试：热点参数限流=============");
        int i = 10/0;
        return "..............测试：热点参数限流";
    }
    public String del_hotkey(String p1, String p2, BlockException blockException) {
        //sentinel系统默认的提示：Block by Sentinel (flow limiting)
        return "..............del_hotkey";
    }

}
