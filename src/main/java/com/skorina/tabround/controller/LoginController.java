package com.skorina.tabround.controller;

import com.skorina.tabround.domain.User;
import com.skorina.tabround.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private RegistrationService registrationService;

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
        boolean isUserCreated = registrationService.addUser(user);
        if (!isUserCreated) {
            model.addAttribute("usernameError", "User exists!");
            return "registration";
        }
        return "redirect:/";
    }


}
