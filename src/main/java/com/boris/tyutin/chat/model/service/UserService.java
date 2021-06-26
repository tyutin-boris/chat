package com.boris.tyutin.chat.model.service;

import com.boris.tyutin.chat.model.entity.User;
import com.boris.tyutin.chat.model.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
