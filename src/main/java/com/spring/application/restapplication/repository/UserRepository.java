package com.spring.application.restapplication.repository;

import com.spring.application.restapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
