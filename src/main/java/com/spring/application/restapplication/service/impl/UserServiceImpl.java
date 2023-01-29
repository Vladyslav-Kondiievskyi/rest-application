package com.spring.application.restapplication.service.impl;

import com.spring.application.restapplication.model.User;
import com.spring.application.restapplication.repository.UserRepository;
import com.spring.application.restapplication.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return userRepository.getReferenceById(id);
    }
}
