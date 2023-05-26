package com.chatroom.chatroom.controller;

import com.chatroom.chatroom.domain.response.LoginResponse;
import com.chatroom.chatroom.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class LoginController {

//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public EntityResponse<LoginResponse> api_login(){
//
//
//    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public EntityResponse<LoginResponse> api_login(){


    }


}
