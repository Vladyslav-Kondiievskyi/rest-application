package com.spring.application.restapplication.service;

import com.spring.application.restapplication.model.User;

public interface UserService {
    User save(User user);

    User get(Long id);
}
