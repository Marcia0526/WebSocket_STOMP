package com.marcia.stomp_websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
@Configuration
//开启websocket支持：开启使用STOMP协议来传输基于代理（message broker）的消息
@EnableWebSocketMessageBroker
// 实现WebSocketMessageBrokerConfigurer接口，并通过复写其方法来配置WebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

   //注册STOMP协议的节点（endpoint）
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个STOMP的endpoint,并指定使用SockJS协议
        registry.addEndpoint("/endpointWisely").withSockJS();
    }

    // 配置消息代理（Message Broker）
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
