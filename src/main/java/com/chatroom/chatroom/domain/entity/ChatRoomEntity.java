package com.chatroom.chatroom.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "chatroom")
public class ChatRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roomId;

    @Column
    private String roomTitle;

    @Column
    private String roomContent;

    @Column
    private int people;

    protected ChatRoomEntity() {
    }

    private ChatRoomEntity(long roomId, String roomTitle, String roomContent, int people) {
        this.roomId = roomId;
        this.roomTitle = roomTitle;
        this.roomContent = roomContent;
        this.people = people;
    }

    public static ChatRoomEntity of(long roomId, String roomTitle, String roomContent, int people){
        return new ChatRoomEntity(roomId,roomTitle,roomContent,people);
    }

}
