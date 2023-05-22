package com.chatroom.chatroom.config;

import com.chatroom.chatroom.domain.response.ChatMessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
public class WebScoketInterceptor implements ChannelInterceptor {



    int cnt = 0;

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        MessageHeaders headers = message.getHeaders(); //메세지 들어올때 헤더
        MultiValueMap<String, String> map= headers.get(StompHeaderAccessor.NATIVE_HEADERS, MultiValueMap.class);

        if(StompCommand.CONNECT == accessor.getCommand()){
            System.out.println("처음 접속할때");
        }else if(StompCommand.SUBSCRIBE == accessor.getCommand()){ //roomId
            String chatRoomId = map.getFirst("roomId");
            System.out.println(chatRoomId);
            cnt++;
            if(cnt >= 2){ //인원관리
                throw new IllegalStateException("접속 불가.");
            }

            System.out.println("주소 구독할때");
        }else if(StompCommand.SEND == accessor.getCommand()){
            System.out.println("메세지 보낼때");
        }else if(StompCommand.DISCONNECT == accessor.getCommand()){
            System.out.println("접속 끊을때");
        }
        return message;
    }

}
