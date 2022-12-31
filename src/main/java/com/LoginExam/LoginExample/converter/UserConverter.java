package com.LoginExam.LoginExample.converter;
import com.LoginExam.LoginExample.entity.Role;
import com.LoginExam.LoginExample.entity.User;
import com.LoginExam.LoginExample.request.CreateUserRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UserConverter {
    public User convertToUser(CreateUserRequest request, String encodedPassword, Role role) {
        User response = new User();
        response.setUserName(request.getUserName());
        response.setPassword(encodedPassword);
        response.setEnabled(true);
        response.setRoles(Collections.singleton(role));
        return response;
    }

}
