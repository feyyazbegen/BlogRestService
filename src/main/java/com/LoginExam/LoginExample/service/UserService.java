package com.LoginExam.LoginExample.service;

import com.LoginExam.LoginExample.entity.User;
import com.LoginExam.LoginExample.request.CreateUserRequest;

public interface UserService {
    User createUser(CreateUserRequest createUserRequest);
}
