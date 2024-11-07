package com.edu.service;

import com.edu.entity.User;
import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    void saveUser(User user);
}
