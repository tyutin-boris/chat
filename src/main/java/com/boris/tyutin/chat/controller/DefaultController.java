package com.boris.tyutin.chat.controller;

import com.boris.tyutin.chat.model.entity.Message;
import com.boris.tyutin.chat.model.entity.User;
import com.boris.tyutin.chat.model.service.MessageService;
import com.boris.tyutin.chat.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api")
public class DefaultController {

    private final MessageService messageService;
    private final UserService userService;

    public DefaultController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping("/messages")
    public String getMessages(Model model) {
        List<Message> allMessage = messageService.findAllMessage();
        model.addAttribute("messages", allMessage);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }
}
