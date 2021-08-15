package edu.hue.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import edu.hue.springcloud.entity.CommonResult;
import edu.hue.springcloud.entity.Payment;

/**
 * @author 47552
 * @date 2021/08/13
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException01(BlockException exception) {
        return new CommonResult(444,"客户自定义，服务不可用 handlerException01");
    }

    public static CommonResult handlerException02(BlockException exception) {
        return new CommonResult(444,"客户自定义，服务不可用 handlerException02");
    }
}
