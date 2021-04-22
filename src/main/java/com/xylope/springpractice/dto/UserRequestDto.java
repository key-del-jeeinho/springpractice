package com.xylope.springpractice.dto;

import lombok.Getter;
import lombok.Setter;

public class UserRequestDto {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private int age;
    @Getter @Setter
    private String hobby;
    @Getter @Setter
    private String sexual;
    @Getter @Setter
    private String email;

    @Override
    public String toString() {
        return name + " / " + age + " / " + sexual + "\nhobby : " + hobby + "\nemail : " + email;
    }
}
