package com.spring.application.restapplication.service.mapper;

import com.spring.application.restapplication.dto.UserRequestDto;
import com.spring.application.restapplication.dto.UserResponseDto;
import com.spring.application.restapplication.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements RequestDtoMapper<UserRequestDto, User>,
        ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public User mapToModel(UserRequestDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setDateOfBirth(dto.getDateOfBirth());
        return user;
    }

    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setFirstName(user.getFirstName());
        responseDto.setLastName(user.getLastName());
        responseDto.setDateOfBirth(user.getDateOfBirth());
        return responseDto;
    }
}
