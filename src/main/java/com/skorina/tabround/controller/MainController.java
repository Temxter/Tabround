package com.skorina.tabround.controller;

import com.skorina.tabround.domain.Message;
import com.skorina.tabround.domain.User;
import com.skorina.tabround.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/")
    public String indexPage() {
        return "redirect:messages";
    }

    @GetMapping("/messages")
    public String getMessages(@RequestParam(required = false) String filter, Model model) {
        Iterable<Message> messages;
        if (!StringUtils.isEmpty(filter)) {
            messages = messageRepository.findByTextContainingIgnoreCase(filter);
        } else {
            messages = messageRepository.findAll();
        }
        model.addAttribute("messages", messages);
        return "main";
    }

    @PostMapping("/messages/add")
    public String addMessage(@RequestParam String text,
                             @RequestParam String tag,
                             @AuthenticationPrincipal User user) {
        Message message = new Message(text, tag, user);
        messageRepository.save(message);
        return "redirect:/messages";
    }
}
