package com.xylope.springpractice.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class User {
    //@Getter -> getter를 사용할경우 이를 json 프로퍼티로 인식한다
    private static final User defaultUser = new User("홍길동", 0, "010-1234-5678");

    private String name;
    private int age;
    @JsonProperty("phone_number")
    private String phoneNumber;

    public static User defaultUser() {
        return defaultUser;
    }
}
