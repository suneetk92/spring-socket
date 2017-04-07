package com.sk;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * Created by Sk on 07-04-2017.
 */

@Component
public class SocketMessageHandler extends AbstractWebSocketHandler {
    WebSocketSession webSocketSession;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Connection Establised");
        this.webSocketSession = session;
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message.getPayload().equals("CLOSE")) {
            webSocketSession.close();
        } else {
            System.out.println("Received: " + message.getPayload());
        }
    }

    public void sendMessage(String msg) {
        System.out.println("Trying to send: " + msg);
        if (webSocketSession != null && webSocketSession.isOpen()) {
            try {
                System.out.println("Now Sending: " + msg);
                WebSocketMessage<String> message = new WebSocketMessage<String>() {
                    @Override
                    public String getPayload() {
                        return msg;
                    }

                    @Override
                    public int getPayloadLength() {
                        return msg.length();
                    }

                    @Override
                    public boolean isLast() {
                        return true;
                    }
                };
                webSocketSession.sendMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Don't have open session to send: " + msg);
        }
    }
}
