package com.skorina.tabround.controller;

import com.skorina.tabround.domain.Message;
import com.skorina.tabround.domain.User;
import com.skorina.tabround.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    public String indexPage() {
        return "redirect:messages";
    }

    @GetMapping("/messages")
    public String getMessages(@RequestParam(required = false) String filter, Model model) {
        Iterable<Message> messages = messageService.getMessages(filter);
        model.addAttribute("messages", messages);
        return "main";
    }



    @PostMapping("/messages/add")
    public String addMessage(@RequestParam String text,
                             @RequestParam String tag,
                             @AuthenticationPrincipal User user) {
        messageService.addMessage(text, tag, user);
        return "redirect:/messages";
    }

}
