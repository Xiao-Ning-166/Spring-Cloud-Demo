package edu.hue.springcloud.controller;

import edu.hue.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 47552
 * @date 2021/08/11
 */
@RestController
public class IMessageproviderController {

    @Autowired
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMsg")
    public String sendMessage(){

        return iMessageProvider.sendMsg();
    }
}
