package com.xylope.springpractice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
    @Pointcut("execution(* AspectExam.*())")
    public void Loggable() {}
    
    @Before("execution(* com.xylope.springpractice.aop.*.*())")
    public void beforeLogging() {
        System.out.println("before Logging...");
    }

    @AfterReturning("Loggable()")
    public void afterReturningLogging() {
        System.out.println("after returning Logging...");
    }

    @AfterThrowing("Loggable()")
    public void afterThrowingLogging() {
        System.out.println("after throwing Logging...");
    }

    @After("Loggable()")
    public void afterLogging() {
        System.out.println("after Logging...");
    }

    @Around("Loggable()")
    public Object aroundLogging(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around Logging IS_STARTED");
        try {
            Object rs = pjp.proceed();
            System.out.println("around Logging IS_END");
            return rs;
        } catch (Exception e) {
            System.out.println("AspectJ throw exception on around Logging...");
            return null;
        }
    }


}
