package com.xylope.springpractice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.xylope.springpractice.annotation.CustomValidate;
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
    @CustomValidate()
    int age;
    @NotBlank
    String email;
    @NotBlank
    String password;
}
