package com.LoginExam.LoginExample.service;

import com.LoginExam.LoginExample.entity.User;
import com.LoginExam.LoginExample.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService{
    private final UserRepository userRepository;

    public MainServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }
}
