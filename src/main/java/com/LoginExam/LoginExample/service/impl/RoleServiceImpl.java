package com.LoginExam.LoginExample.service.impl;

import com.LoginExam.LoginExample.entity.Role;
import com.LoginExam.LoginExample.repository.RoleRepository;
import com.LoginExam.LoginExample.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
