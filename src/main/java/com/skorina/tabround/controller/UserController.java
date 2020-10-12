package com.skorina.tabround.controller;

import com.skorina.tabround.domain.Roles;
import com.skorina.tabround.domain.User;
import com.skorina.tabround.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("users")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepository userRepository;

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
        return "redirect:/users";
    }
}
