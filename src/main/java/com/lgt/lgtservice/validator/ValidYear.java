package com.lgt.lgtservice.validator;

import jakarta.validation.Constraint;

import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = YearValidator.class)
@Target({ElementType.FIELD})
public @interface ValidYear {
    String message() default "{javax.validation.constraints.ValidYear.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min() default 2010;
}
