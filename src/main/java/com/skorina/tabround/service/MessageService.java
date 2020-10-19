package com.skorina.tabround.service;

import com.skorina.tabround.domain.Message;
import com.skorina.tabround.domain.User;
import com.skorina.tabround.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Iterable<Message> getMessages(String filter) {
        Iterable<Message> messages;
        if (!StringUtils.isEmpty(filter)) {
            messages = messageRepository.findByTextContainingIgnoreCase(filter);
        } else {
            messages = messageRepository.findAll();
        }
        return messages;
    }


    public void addMessage(String text, String tag, User user) {
        Message message = new Message(text, tag, user);
        messageRepository.save(message);
    }
}
