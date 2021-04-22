package com.xylope.springpractice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Getter @Setter @JsonProperty("phone_number")
    private String phoneNumber;

    @Override
    public String toString() {
        return String.format("%s\nemail : %s\npassword : %s\nphone : %s", account, email, password, phoneNumber);
    }
}
