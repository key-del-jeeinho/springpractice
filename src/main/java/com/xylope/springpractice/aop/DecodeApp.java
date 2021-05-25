package com.xylope.springpractice.aop;

import com.xylope.springpractice.dto.UserDto;
import com.xylope.springpractice.objectmapper.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Aspect
@Component
public class DecodeApp {
    @Pointcut("execution(* com.xylope.springpractice.controller..*.*(..))")
    private void method() {}

    @Pointcut("@annotation(com.xylope.springpractice.annotation.Decode)")
    public void method2() {}

    @Before("method() && method2()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        for(Object arg : args) {
            if(arg instanceof UserDto) {
                UserDto user = (UserDto) arg;
                String base64Email = user.getEmail();


                String email = new String(Base64.getDecoder().decode(base64Email),
                        StandardCharsets.UTF_8);
                user.setEmail(email);
            }
        }
    }

    @AfterReturning(value = "method() && method2()", returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
        if(result instanceof UserDto) {
            UserDto user = UserDto.class.cast(result);
            String email = user.getEmail();
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes(StandardCharsets.UTF_8));
            user.setEmail(base64Email);
        }
    }
}
