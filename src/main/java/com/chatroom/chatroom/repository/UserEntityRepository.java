package com.chatroom.chatroom.repository;

import com.chatroom.chatroom.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, String> {


}