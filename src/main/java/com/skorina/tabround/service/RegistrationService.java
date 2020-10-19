package com.skorina.tabround.service;

import com.skorina.tabround.domain.Roles;
import com.skorina.tabround.domain.User;
import com.skorina.tabround.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    public boolean addUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb == null) {
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Roles.USER));
        userRepository.save(user);
        return true;
    }
}
