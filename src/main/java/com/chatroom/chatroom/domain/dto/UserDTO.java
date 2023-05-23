package com.chatroom.chatroom.domain.dto;

import com.chatroom.chatroom.domain.entity.UserEntity;
import lombok.NoArgsConstructor;

public record UserDTO(
        String user_id,
        String user_password,
        String user_nickname
) {


    public static UserDTO of(String user_id, String user_password, String user_nickname) {
        return new UserDTO(user_id,user_password,user_nickname);
    }

    public UserEntity toEntity(UserDTO userDTO){
        return UserEntity.of(userDTO.user_id(),userDTO.user_password(),userDTO.user_nickname());
    }

    public static UserDTO from(UserEntity userEntity){
        return UserDTO.of(userEntity.getUser_id(),userEntity.getUser_password(),userEntity.getNickname());
    }


}
