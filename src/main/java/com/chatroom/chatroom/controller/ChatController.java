package com.chatroom.chatroom.controller;

import com.chatroom.chatroom.domain.response.ChatMessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessageSendingOperations template;


    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessageResponse chatMessage, SimpMessageHeaderAccessor accessor) {
        System.out.println("메세지 : " + chatMessage.message());
        template.convertAndSend("/topic/public/" + chatMessage.roomId(), chatMessage);
    }

    @MessageMapping("/chat.addUser")
    public void addUser(@Payload ChatMessageResponse chatMessage, SimpMessageHeaderAccessor accessor) {
        template.convertAndSend("/topic/public/" + chatMessage.roomId(), new ChatMessageResponse(
                chatMessage.name(),
                " 님이 채팅방에 입장하셨습니다.",
                chatMessage.roomId()
        ));

    }


}
