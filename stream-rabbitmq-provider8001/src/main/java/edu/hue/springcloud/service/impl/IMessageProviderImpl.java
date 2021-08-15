package edu.hue.springcloud.service.impl;

//import edu.hue.springcloud.service.IMessageProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.messaging.Source;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.support.MessageBuilder;
//
//import java.util.UUID;
//
//@EnableBinding(Source.class)  //定义消息推送通道
//public class IMessageProviderImpl implements IMessageProvider {
//
//    //消息发送通道
//    @Autowired
//    private MessageChannel output;
//
//    @Override
//    public String sendMsg() {
//        String serial = UUID.randomUUID().toString();
//        output.send(MessageBuilder.withPayload(serial).build());
//        System.out.println("***********serial:"+serial);
//        return serial;
//    }
//}


import edu.hue.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(Source.class)    //定义消息的推送管道
public class IMessageProviderImpl implements IMessageProvider {

    //消息发送管道
    @Autowired
    private MessageChannel output;

    @Override
    public String sendMsg() {
        String message = UUID.randomUUID().toString();
//        Message<String> build = MessageBuilder.withPayload(message).build();
        output.send(MessageBuilder.withPayload(message).build());
        System.out.println("========="+message+"=========");
        return null;
    }
}
