package com.xylope.springpractice.controller;

import com.xylope.springpractice.annotation.Decode;
import com.xylope.springpractice.annotation.Timer;
import com.xylope.springpractice.aop.AspectExam;
import com.xylope.springpractice.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;


@RestController
@RequestMapping("/aop")
public class AOPTestController {
    @Autowired @NotNull
    private AspectExam exam;

    @GetMapping("/test-log")
    public void testLogger() {
        exam.printProfile();
    }

    @GetMapping("/get-user/{name}")
    public UserDto getUser(@PathVariable String name,
                           @RequestParam int age,
                           @RequestParam String email,
                           @RequestParam String password) {
        UserDto user = new UserDto();
        user.setUserName(name);
        user.setAge(age);
        user.setEmail(email);
        user.setPassword(password);

        System.out.println("get method================================");
        System.out.println("get method - name : " + user.getUserName());
        System.out.println("get method - email : " + user.getEmail());
        System.out.println("get method - password : " + user.getPassword());
        System.out.println("get method - age : " + user.getAge());
        System.out.println("===========================================");

        return user;
    }

    //@Decode
    @PostMapping("/post-user")
    public UserDto postUser(@Valid @RequestBody UserDto user) {
        System.out.println("post method================================");
        System.out.println("post method - toString : " + user.toString());
        System.out.println("===========================================");

        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Thread.sleep(1000 * 2);

        stopWatch.stop();

        System.out.println("total time in delete() : " + stopWatch.getTotalTimeMillis());
    }
}
