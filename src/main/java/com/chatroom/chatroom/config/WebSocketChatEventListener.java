package com.chatroom.chatroom.config;


import com.chatroom.chatroom.domain.response.ChatMessageResponse;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import java.util.HashMap;

@Component
@RequiredArgsConstructor
public class WebSocketChatEventListener {

    private final SimpMessageSendingOperations template;

    //구독할려고 할때 발생되는 이벤트
    @EventListener
    public void handlerConnetionListener(SessionConnectEvent event) {
        System.out.println("테스트 연결");
    }

    @EventListener
    public void handlerDisconnectionListener(SessionDisconnectEvent event) {
        System.out.println("테스트 끊김");
    }

}
