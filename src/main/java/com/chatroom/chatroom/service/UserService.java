package com.chatroom.chatroom.service;

import com.chatroom.chatroom.domain.dto.UserDTO;
import com.chatroom.chatroom.domain.entity.UserEntity;
import com.chatroom.chatroom.repository.UserEntityRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserEntityRepository entityRepository;

    public UserDTO find_user(String userid, String password){
        UserEntity use
    }


}
