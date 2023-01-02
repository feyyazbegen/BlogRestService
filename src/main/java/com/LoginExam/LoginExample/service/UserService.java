package com.LoginExam.LoginExample.service;

import com.LoginExam.LoginExample.entity.User;
import com.LoginExam.LoginExample.request.CreateUserRequest;

import java.util.Optional;

public interface UserService {
    User createUser(CreateUserRequest createUserRequest);
    User findByUserName(String userName);

    Optional<User> getOneUserById(Long user_id);
}
