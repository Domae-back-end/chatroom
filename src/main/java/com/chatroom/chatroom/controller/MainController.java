package com.chatroom.chatroom.controller;

import com.chatroom.chatroom.domain.dto.UserDetail;
import com.chatroom.chatroom.service.ChatRoomService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ChatRoomService chatRoomService;


    @RequestMapping("/")
    public String main_page(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String roomId,
            HttpServletRequest req,
            HttpServletResponse res
    ) {
        if(category == null){
            category = "index";
        }
        req.setAttribute("page","page/"+category);
        req.setAttribute("roomlist",chatRoomService.chatRoomList());
        if(roomId != null){
            req.setAttribute("roomInfo",chatRoomService.findChatRoom(Long.parseLong(roomId)));
        }

        //SecurityContextHolder 파일안에 데이터 조회.
        UserDetail test = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(test.getPassword());
        System.out.println(test.getAuthorities());
        return "index";
    }

    @RequestMapping("/errer")
    public String errer(){
        return "errer/errer";
    }

    @RequestMapping("/login")
    public String login(){
        return "join/login";
    }


}
