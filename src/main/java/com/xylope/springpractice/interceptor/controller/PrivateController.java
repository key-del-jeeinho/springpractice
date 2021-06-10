package com.xylope.springpractice.interceptor.controller;

import com.xylope.springpractice.interceptor.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private-api")
@Auth
@Slf4j
public class PrivateController {
    @GetMapping("/hello")
    public String hello() {
        log.info("private hello controller is running!");
        return "private hello";
    }
}
