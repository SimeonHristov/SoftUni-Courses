package com.example.structure.util;

import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidationUtilImpl implements ValidationUtil {


    private final Validator validator;

    public ValidationUtilImpl() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    };


    @Override
    public <E> Set<ConstraintViolation<E>> violation(E entity) {
        return validator.validate(entity);
    }

    @Override
    public <E> boolean isValid(E entity) {
        return validator.validate(entity).isEmpty();
    }
}
