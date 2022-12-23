package com.LoginExam.LoginExample.repository;

import com.LoginExam.LoginExample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String name);
}
