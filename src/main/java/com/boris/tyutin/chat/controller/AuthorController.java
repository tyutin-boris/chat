package com.boris.tyutin.chat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthorController {

    @GetMapping("/logout")
    public void logout() {

        System.out.println();
    }
}
