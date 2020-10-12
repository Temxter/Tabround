package com.skorina.tabround.controller;

import com.skorina.tabround.domain.Message;
import com.skorina.tabround.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getMessages(Model model) {
        model.addAttribute("messages", messageRepository.findAll());
        return "main";
    }

    @PostMapping("/messages/add")
    public String addMessage(@RequestParam String text, @RequestParam String tag) {
        Message message = new Message(text, tag);
        messageRepository.save(message);
        return "redirect:/messages";
    }


}
