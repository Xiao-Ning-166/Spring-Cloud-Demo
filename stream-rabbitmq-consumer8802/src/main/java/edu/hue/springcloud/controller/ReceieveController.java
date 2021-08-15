package edu.hue.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 47552
 * @date 2021/08/11
 */
@RestController
@EnableBinding(Sink.class)
public class ReceieveController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> msg) {
        System.out.println("消费者1，端口号："+serverPort+"，消息内容："+msg.getPayload());
    }

}
