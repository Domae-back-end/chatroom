package com.chatroom.chatroom.config;


import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@Component
public class WebSocketChatEventListener {


    //구독할려고 할때 발생되는 이벤트
    @EventListener
    public void handlerConnetionListener(SessionConnectEvent event) {

        System.out.println("테스트 연결");
    }

    @EventListener
    public void handlerDisconnectionListener(SessionDisconnectEvent event){
        System.out.println("테스트 끊김");
    }

}
