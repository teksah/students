package com.sda.javagda34.students.repository;

import com.sda.javagda34.students.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
