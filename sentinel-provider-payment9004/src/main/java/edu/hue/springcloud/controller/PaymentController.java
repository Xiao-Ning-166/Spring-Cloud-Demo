package edu.hue.springcloud.controller;

import edu.hue.springcloud.entity.CommonResult;
import edu.hue.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 47552
 * @date 2021/08/14
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static final HashMap<Long,Payment> map = new HashMap<>();
    static {
        map.put(1L,new Payment(1L,"aaaaaaaa"));
        map.put(2L,new Payment(2L,"bbbbbbbb"));
        map.put(3L,new Payment(3L,"cccccccc"));
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> payment(@PathVariable("id") Long id) {
        Payment payment = map.get(id);
        return new CommonResult<>(200,"成功调用！端口："+serverPort, payment);
    }
}
