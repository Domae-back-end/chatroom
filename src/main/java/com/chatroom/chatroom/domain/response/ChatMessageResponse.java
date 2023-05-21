package com.chatroom.chatroom.domain.response;

public record ChatMessageResponse (
        String name,
        String message,
        String roomId
){

    public ChatMessageResponse(String name, String message,String roomId) {
        this.name = name;
        this.roomId = roomId;
        this.message = message;
    }

}
