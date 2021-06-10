package com.xylope.springpractice.interceptor.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuthException extends RuntimeException {
    public AuthException(String msg) {
        super(msg);
    }
}
