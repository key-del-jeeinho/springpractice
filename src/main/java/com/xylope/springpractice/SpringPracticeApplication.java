package com.xylope.springpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringPracticeApplication.class, args);
    }
}
