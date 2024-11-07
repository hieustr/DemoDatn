package com.edu.service.impl;

import com.edu.entity.Role;
import com.edu.repository.RoleRepository;
import com.edu.service.RoleService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}
