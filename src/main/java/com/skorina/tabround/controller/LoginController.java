package com.skorina.tabround.controller;

import com.skorina.tabround.domain.Roles;
import com.skorina.tabround.domain.User;
import com.skorina.tabround.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationForm() {
        return "registration";
    }

    @PostMapping("/login")
    public String login() {
        return "redirect:/";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDatabase = userRepository.findByUsername(user.getUsername());
        if (userFromDatabase != null) {
            model.addAttribute("usernameError", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Roles.USER));
        userRepository.save(user);
        return "redirect:/";
    }
}
