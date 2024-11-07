package com.edu.service;

import com.edu.entity.Role;
import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(String name);
    void saveRole(Role role);
}
