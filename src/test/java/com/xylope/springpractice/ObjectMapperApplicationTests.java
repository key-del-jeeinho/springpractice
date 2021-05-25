package com.xylope.springpractice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xylope.springpractice.objectmapper.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.NotNull;

@SpringBootTest
public class ObjectMapperApplicationTests {
    @Test
    public void contextLoads() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        //object to text
        User user = User.defaultUser();
        String text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        //text to object
        //object mapper need default constructor
        User objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }
}
