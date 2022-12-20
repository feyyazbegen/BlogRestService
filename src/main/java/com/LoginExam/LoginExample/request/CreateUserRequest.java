package com.LoginExam.LoginExample.request;

import com.LoginExam.LoginExample.entity.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CreateUserRequest {

    private String userName;
    private String password;
}
