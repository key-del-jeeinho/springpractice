package com.xylope.springpractice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Logger {
    @Pointcut("@annotation(Loggable)")
    public void loggable() {}
    
    @Before("loggable()")
    public void beforeLogging() {
        System.out.println("before Logging...");
    }

    @AfterReturning()
    public void afterReturningLogging() {
        System.out.println("after returning Logging...");
    }

    @AfterThrowing()
    public void afterThrowingLogging() {
        System.out.println("after throwing Logging...");
    }

    @After("loggable()")
    public void afterLogging() {
        System.out.println("after Logging...");
    }

    @Around("loggable()")
    public Object aroundLogging(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around Logging...");
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
