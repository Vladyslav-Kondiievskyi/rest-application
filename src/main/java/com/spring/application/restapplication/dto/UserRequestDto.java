package com.spring.application.restapplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.application.restapplication.validation.CustomDataConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Data;

@Data
public class UserRequestDto {
    @Size(min = 1,max = 100)
    @NotNull
    private String firstName;
    @Size(min = 1,max = 100)
    @NotNull
    private String lastName;
    @CustomDataConstraint(message = "The date is incorrect, please enter your date of birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;
}
