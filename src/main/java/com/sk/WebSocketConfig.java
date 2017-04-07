package com.sk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by Sk on 06-04-2017.
 */

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

    @Autowired
    SocketMessageHandler socketMessageHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(socketMessageHandler, "/counter");
    }

}
