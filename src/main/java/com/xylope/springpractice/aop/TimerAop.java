package com.xylope.springpractice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {
    @Pointcut("execution(* com.xylope.springpractice.controller..*.*(..))")
    private void method() {}

    @Pointcut("@annotation(com.xylope.springpractice.annotation.Timer)")
    public void method2() {}

    @Around("method() && method2()")
    private Object enableTimer(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = pjp.proceed();

        stopWatch.stop();

        System.out.println("total time in enableTimer() : " + stopWatch.getTotalTimeMillis());
        return result;
    }
}
