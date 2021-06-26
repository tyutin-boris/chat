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

import java.util.List;

@Controller
@RequestMapping("/messages")
public class DefaultController {

    private final MessageService messageService;
    private final UserService userService;

    public DefaultController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping
    public String getMessages(Model model) {
        List<Message> allMessage = messageService.findAllMessage();
        model.addAttribute("messages", allMessage);
        return "index";
    }

    @PostMapping
    public String add(@RequestParam String title, @RequestParam String text) {
        User user = userService.findById(0);
        Message message = Message
                .builder()
                .author(user)
                .title(title)
                .text(text).build();
        messageService.save(message);
        return "redirect:/messages";
    }
}
