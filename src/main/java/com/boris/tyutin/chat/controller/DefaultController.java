package com.boris.tyutin.chat.controller;

import com.boris.tyutin.chat.model.entity.Message;
import com.boris.tyutin.chat.model.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DefaultController {

    private final MessageService messageService;

    public DefaultController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String getMessages(Model model) {
        List<Message> allMessage = messageService.findAllMessage();
        model.addAttribute("messages", allMessage);
        return "index";
    }
}
