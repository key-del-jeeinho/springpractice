package com.xylope.springpractice.controller;

import com.xylope.springpractice.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageResponseController {
    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    @ResponseBody
    @GetMapping("/user")
    public UserDto user() {
        UserDto user = new UserDto();
        user.setUserName("jeeinho");
        user.setEmail("xylopeofficial@gmail.com");
        user.setAge(17);
        return user;
    }
}

