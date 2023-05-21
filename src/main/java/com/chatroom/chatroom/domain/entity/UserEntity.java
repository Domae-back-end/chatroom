package com.chatroom.chatroom.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user")
public class UserEntity {

    @Id
    private String user_id;

    @Column
    private String user_password;

    @Column
    private String nickname;

    protected UserEntity(){}

    private UserEntity(String user_id, String user_password, String nickname) {
        this.user_id = user_id;
        this.user_password = user_password;
        this.nickname = nickname;
    }

    public static UserEntity of(String user_id, String user_password, String nickname) {
        return new UserEntity(user_id,user_password,nickname);
    }


}
