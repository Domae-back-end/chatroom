package com.chatroom.chatroom.service;

import com.chatroom.chatroom.domain.dto.ChatRoomDTO;
import com.chatroom.chatroom.domain.dto.UserDTO;
import com.chatroom.chatroom.domain.entity.ChatRoomEntity;
import com.chatroom.chatroom.repository.ChatRoomEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomEntityRepository chatRoomEntityRepository;


    public List<ChatRoomDTO> chatRoomList(){
        return chatRoomEntityRepository.findAll()
                .stream().map(a -> ChatRoomDTO.of(
                        a.getRoomId(),
                        a.getRoomTitle(),
                        a.getRoomContent(),
                        a.getPeople()
                )).collect(Collectors.toList());
    }

    public ChatRoomDTO findChatRoom(long roomId){
        return chatRoomEntityRepository.findById(roomId)
                .map(a -> ChatRoomDTO.of(
                    a.getRoomId(),
                    a.getRoomTitle(),
                    a.getRoomContent(),
                    a.getPeople()
                )).get();
    }

    public int check_roomPeople(String roomId){
        System.out.println();
        return 1;
    }



}
