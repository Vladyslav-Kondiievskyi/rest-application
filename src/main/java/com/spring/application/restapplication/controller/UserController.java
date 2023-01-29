package com.spring.application.restapplication.controller;

import com.spring.application.restapplication.dto.UserRequestDto;
import com.spring.application.restapplication.dto.UserResponseDto;
import com.spring.application.restapplication.model.User;
import com.spring.application.restapplication.service.UserService;
import com.spring.application.restapplication.service.mapper.RequestDtoMapper;
import com.spring.application.restapplication.service.mapper.ResponseDtoMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper;
    private final RequestDtoMapper<UserRequestDto, User> userRequestDtoMapper;

    public UserController(UserService userService,
                          ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper,
                          RequestDtoMapper<UserRequestDto, User> userRequestDtoMapper) {
        this.userService = userService;
        this.userResponseDtoMapper = userResponseDtoMapper;
        this.userRequestDtoMapper = userRequestDtoMapper;
    }

    @PostMapping("/add")
    public UserResponseDto add(@RequestBody @Validated UserRequestDto requestDto) {
        User user = userService.save(userRequestDtoMapper.mapToModel(requestDto));
        return userResponseDtoMapper.mapToDto(user);
    }

    @GetMapping("/get/{id}")
    public UserResponseDto get(@PathVariable Long id) {
        return userResponseDtoMapper.mapToDto(userService.get(id));
    }
}
