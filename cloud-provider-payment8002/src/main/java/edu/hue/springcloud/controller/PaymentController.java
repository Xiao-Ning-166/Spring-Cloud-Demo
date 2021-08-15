package edu.hue.springcloud.controller;

import edu.hue.springcloud.entity.CommonResult;
import edu.hue.springcloud.entity.Payment;
import edu.hue.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author 47552
 * @date 2021/08/07
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/add")
    public CommonResult add(@RequestBody Payment payment) {
        int res = paymentService.add(payment);
        log.info("********插入结果：{}*********",res);
        if (res > 0) {
            return new CommonResult(200,"插入数据成功！serverPort："+serverPort);
        } else {
            return new CommonResult(400,"插入数据失败！serverPort："+serverPort);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果：{}*********",payment);
        if (payment != null) {
            return new CommonResult<Payment>(200,"查询数据成功！serverPort："+serverPort,payment);
        } else {
            return new CommonResult<Payment>(400,"查询数据失败！serverPort："+serverPort);
        }
    }

}
