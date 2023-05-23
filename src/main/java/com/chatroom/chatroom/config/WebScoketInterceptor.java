package com.chatroom.chatroom.config;

import com.chatroom.chatroom.domain.response.ChatMessageResponse;
import com.chatroom.chatroom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

import java.util.HashMap;

@Slf4j
public class WebScoketInterceptor implements ChannelInterceptor {

    @Autowired
    ChatRoomService chatRoomService;

    HashMap<String, Integer> roomList = new HashMap<>();

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        MessageHeaders headers = message.getHeaders(); //메세지 들어올때 헤더
        MultiValueMap<String, String> map= headers.get(StompHeaderAccessor.NATIVE_HEADERS, MultiValueMap.class);

        if(StompCommand.CONNECT == accessor.getCommand()){
            System.out.println("처음 접속할때");
        }else if(StompCommand.SUBSCRIBE == accessor.getCommand()){ //roomId
            String chatRoomId = map.getFirst("roomId");

            System.out.println("?! : "+roomList);
            System.out.println(chatRoomId);
//            아니 왜 도대체 charRoomService 를 호출하면 오류가 나오지..?
            System.out.println("?! : "+chatRoomService.check_roomPeople(chatRoomId));
//
//            if(roomList.containsKey(chatRoomId)){
//                if(roomList.get(chatRoomId) > chatRoomService.check_roomPeople(chatRoomId)){
//                  //throw new IllegalStateException("인원 초과");
//                }else{
//                    roomList.put(chatRoomId,roomList.get(chatRoomId)+1);
//                }
//            }else{
//                roomList.put(chatRoomId,1);
//            }
            System.out.println(roomList);

            System.out.println("주소 구독할때");
        }else if(StompCommand.SEND == accessor.getCommand()){
            System.out.println("메세지 보낼때");
        }else if(StompCommand.DISCONNECT == accessor.getCommand()){
            System.out.println(map);
            System.out.println("접속 끊을때");
        }
        return message;
    }

}
