package com.chatroom.chatroom.domain.dto;

import com.chatroom.chatroom.domain.dto.UserDTO;
import com.chatroom.chatroom.domain.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetail implements UserDetails {
    private UserDTO user;

    public UserDetail(UserDTO user) {
        this.user = user;
    }

    public UserDetail(UserEntity entity){
        user = user.from(entity);
    }

    @Override
    public String getPassword() {
        return user.user_password();
    }

    @Override
    public String getUsername() {
        return user.user_password();
    }

    //계정이 만료되지 않았는지 리턴 (true: 만료안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //계정이 잠겨있는지 않았는지 리턴. (true:잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //비밀번호가 마료되지 않았는지 리턴한다. (true:만료안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //계정이 활성화(사용가능)인지 리턴 (true:활성화)
    @Override
    public boolean isEnabled() {
        return true;
    }

    //계정이 갖고있는 권한 목록은 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(() -> {
            return "ROLE_USER";
        });
        return collectors;
    }

}
