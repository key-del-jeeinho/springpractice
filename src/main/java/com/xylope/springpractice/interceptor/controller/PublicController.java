package com.xylope.springpractice.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public-api")
public class PublicController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
