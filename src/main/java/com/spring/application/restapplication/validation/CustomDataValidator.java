package com.spring.application.restapplication.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Value;

public class CustomDataValidator implements
        ConstraintValidator<CustomDataConstraint, LocalDate> {
    private LocalDate minAge = LocalDate.now();
    @Value("${max.user.age}")
    private String maxAge;

    @Override
    public void initialize(CustomDataConstraint data) {
    }

    @Override
    public boolean isValid(LocalDate field,
                           ConstraintValidatorContext cxt) {
        if (field != null) {
            LocalDate averageAge = LocalDate.parse(
                    maxAge, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return field.isBefore(minAge) && field.isAfter(averageAge);
        }
        return false;
    }
}
