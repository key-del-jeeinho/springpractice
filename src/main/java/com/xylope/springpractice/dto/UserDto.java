package com.xylope.springpractice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.xylope.springpractice.annotation.Age;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
@ToString
public class UserDto {
    @NotEmpty
    String userName;
    @NotEmpty
    @Age() // = Size (max = 100)
    int age;
    @NotBlank
    String email;
    @NotBlank
    String password;
}
