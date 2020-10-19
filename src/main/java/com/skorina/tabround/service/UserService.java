package com.skorina.tabround.service;

import com.skorina.tabround.domain.Roles;
import com.skorina.tabround.domain.User;
import com.skorina.tabround.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public void saveUser(String username, Map<String, String> form, User user) {
        user.setUsername(username);

        Set<String> roleSet = Arrays.stream(Roles.values())
                .map(Roles::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roleSet.contains(key)) {
                user.getRoles().add(Roles.valueOf(key));
            }
        }

        userRepository.save(user);
    }
}
