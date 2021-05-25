package com.xylope.springpractice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class AccountDto {
    private String account;
    private String email;
    private String password;
    @JsonProperty("phone_number")
    private String phoneNumber;

    @Override
    public String toString() {
        return String.format("%s\nemail : %s\npassword : %s\nphone : %s", account, email, password, phoneNumber);
    }
}
