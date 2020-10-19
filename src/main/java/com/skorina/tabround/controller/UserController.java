package com.skorina.tabround.controller;

import com.skorina.tabround.domain.Roles;
import com.skorina.tabround.domain.User;
import com.skorina.tabround.repository.UserRepository;
import com.skorina.tabround.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("users")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users/users";
    }

    @GetMapping("{user}")
    public String getUserEditor(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Roles.values());
        return "users/userEdit";
    }

    @PostMapping
    public String saveUser(@RequestParam String username,
                           @RequestParam Map<String, String> form,
                           @RequestParam(name = "userId") User user) {
        userService.saveUser(username, form, user);
        return "redirect:/users";
    }


}
