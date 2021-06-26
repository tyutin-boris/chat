package com.boris.tyutin.chat.model.repository;

import com.boris.tyutin.chat.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
