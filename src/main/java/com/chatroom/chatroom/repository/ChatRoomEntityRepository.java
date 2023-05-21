package com.chatroom.chatroom.repository;

import com.chatroom.chatroom.domain.entity.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomEntityRepository extends JpaRepository<ChatRoomEntity, Long> {
}