package com.xylope.springpractice.controller;

import com.xylope.springpractice.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/response")
public class ResponseApiController {
    @GetMapping("/plain-text")
    public String plainText(@RequestParam String text) {
        return text;
    }

    //데이터 요청 및 응답시 형변환 진행
    //???(request)----(object mapper)---->object(method args)
    // object(method return)----(object mapper)---->json(response)
    @PostMapping("/json")
    public UserDto json(@RequestBody UserDto user) {
        return user;
    }

    @PutMapping("/json-with-status")
    public ResponseEntity<UserDto> jsonWithStatus(@RequestBody UserDto user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
