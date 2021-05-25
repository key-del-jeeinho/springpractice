package com.xylope.springpractice.aop;

import org.springframework.stereotype.Service;

@Service
public class AspectExam {
    public void printProfile() {
        System.out.println("print Profile...");
    }
}
