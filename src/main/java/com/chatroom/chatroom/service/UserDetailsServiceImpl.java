package com.chatroom.chatroom.service;

import com.chatroom.chatroom.domain.dto.UserDetail;
import com.chatroom.chatroom.domain.entity.UserEntity;
import com.chatroom.chatroom.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserEntityRepository userEntityRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //인증구현
        System.out.println("?! : "+username);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserEntity entity = userEntityRepository.findById(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("찾을수 없음. : "+username));

        UserDetail user = new UserDetail(entity);

        return user;
    }


}
