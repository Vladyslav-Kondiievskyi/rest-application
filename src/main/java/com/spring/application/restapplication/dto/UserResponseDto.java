package com.spring.application.restapplication.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
