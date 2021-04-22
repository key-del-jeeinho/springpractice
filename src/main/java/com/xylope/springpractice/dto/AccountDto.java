package com.xylope.springpractice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class AccountDto {
    @Getter @Setter
    private String account;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String password;

    @Override
    public String toString() {
        return String.format("%s\nemail : %s\npassword : %s", account, email, password);
    }
}
