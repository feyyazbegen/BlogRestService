package com.LoginExam.LoginExample.service.impl;
import com.LoginExam.LoginExample.converter.UserConverter;
import com.LoginExam.LoginExample.entity.Role;
import com.LoginExam.LoginExample.entity.User;
import com.LoginExam.LoginExample.repository.UserRepository;
import com.LoginExam.LoginExample.request.CreateUserRequest;
import com.LoginExam.LoginExample.service.RoleService;
import com.LoginExam.LoginExample.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserConverter userConverter;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, BCryptPasswordEncoder passwordEncoder, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.userConverter = userConverter;
    }

    @Override
    public User createUser(CreateUserRequest createUserRequest) {
        String encodedPassword = passwordEncoder.encode(createUserRequest.getPassword());
        Role role = roleService.findRoleByName("USER");
        User user = userConverter.convertToUser(createUserRequest, encodedPassword, role);
        return userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Optional<User> getOneUserById(Long userId) {
        return userRepository.findById(userId);
    }

}



