package com.xylope.springpractice.controller;

import com.xylope.springpractice.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class FilterExamController {
    @PostMapping("")
    public User user(@RequestBody User user) {
        log.info("User : {}, {}", user, user);
        return user;
    }
}
