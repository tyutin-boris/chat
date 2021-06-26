package com.boris.tyutin.chat.controller;

import com.boris.tyutin.chat.model.entity.Message;
import com.boris.tyutin.chat.model.entity.User;
import com.boris.tyutin.chat.model.service.MessageService;
import com.boris.tyutin.chat.model.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;
    private final UserService userService;

    public MessageController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestParam String title, @RequestParam String text) {
        User user = userService.findById(0);
        Message message = Message
                .builder()
                .author(user)
                .title(title)
                .text(text)
                .date(LocalDate.now()).build();
        messageService.save(message);
        return ResponseEntity.ok().build();
    }
}
