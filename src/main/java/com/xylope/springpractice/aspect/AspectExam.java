package com.xylope.springpractice.aspect;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AspectExam {
    @Loggable
    public void printProfile() {
        System.out.println("프로필 출력");
    }
}
