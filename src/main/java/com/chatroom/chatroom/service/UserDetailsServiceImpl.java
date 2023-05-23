package com.chatroom.chatroom.service;

import com.chatroom.chatroom.domain.dto.UserDTO;
import com.chatroom.chatroom.domain.entity.UserEntity;
import com.chatroom.chatroom.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserEntityRepository userEntityRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //인증구현
        UserEntity entity = userEntityRepository.findById(username).get();
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username(entity.getUser_id())
                        .password(entity.getUser_password())
                        .roles("USER")
                        .build();
        return user;
    }

}
