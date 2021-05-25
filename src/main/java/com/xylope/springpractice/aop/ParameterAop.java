package com.xylope.springpractice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParameterAop {
    @Pointcut("execution(* com.xylope.springpractice.controller..*.*(..))")
    private void method() {}

    @Before("method()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println(signature.getMethod().getName());

        Object[] args = joinPoint.getArgs();

        for(var arg : args) {
            System.out.println("type : " + arg.getClass().getSimpleName());
            System.out.println("value : " + arg);
        }
    }

    @AfterReturning(value = "method()", returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
        System.out.println("return");
        System.out.println(result);
    }
}
