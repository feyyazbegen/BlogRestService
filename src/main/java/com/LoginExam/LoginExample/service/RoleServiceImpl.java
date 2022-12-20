package com.LoginExam.LoginExample.service;

import com.LoginExam.LoginExample.entity.Role;
import com.LoginExam.LoginExample.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role finRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
