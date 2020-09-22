package com.marcia.stomp_websocket.controller;

import com.marcia.stomp_websocket.entity.WiselyMessage;
import com.marcia.stomp_websocket.entity.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {

    // 当浏览器向服务器发请求时，通过@MessageMapping映射/welcome这个地址，类似@RequestMapping
    @MessageMapping("/welcome")
    // 当服务器端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
    @SendTo("/topic/getResponse")
    public WiselyResponse say (WiselyMessage message) throws Exception{
        Thread.sleep(3000);
        return new WiselyResponse("Welcome "+message.getName()+"!");
    }
}
