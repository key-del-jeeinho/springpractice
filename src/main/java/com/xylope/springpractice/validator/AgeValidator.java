package com.xylope.springpractice.validator;


import com.xylope.springpractice.annotation.Age;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class AgeValidator implements ConstraintValidator<Age, Integer> {
    private int min;
    private int max;

    @Override
    public void initialize(Age constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Integer i, ConstraintValidatorContext constraintValidatorContext) {
        return i > min && i <= max;
    }
}
