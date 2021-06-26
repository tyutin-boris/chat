package com.boris.tyutin.chat.model.repository;

import com.boris.tyutin.chat.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
