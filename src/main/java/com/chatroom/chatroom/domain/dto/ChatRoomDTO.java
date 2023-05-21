package com.chatroom.chatroom.domain.dto;

import com.chatroom.chatroom.domain.entity.ChatRoomEntity;
import com.chatroom.chatroom.domain.entity.UserEntity;

public record ChatRoomDTO(
        long roomId,
        String roomTitle,
        String roomContent,
        int people
) {


    public static ChatRoomDTO of(long roomId, String roomTitle, String roomContent, int people) {
        return new ChatRoomDTO(roomId,roomTitle,roomContent,people);
    }


    public static ChatRoomEntity toEntity(ChatRoomDTO chatRoomDTO){
        return ChatRoomEntity.of(
                chatRoomDTO.roomId(),
                chatRoomDTO.roomTitle(),
                chatRoomDTO.roomContent(),
                chatRoomDTO.people());
    }

    public static ChatRoomDTO from(ChatRoomEntity chatRoomEntity){
        return new ChatRoomDTO(chatRoomEntity.getRoomId(), chatRoomEntity.getRoomTitle(), chatRoomEntity.getRoomContent(), chatRoomEntity.getPeople());
    }

}
