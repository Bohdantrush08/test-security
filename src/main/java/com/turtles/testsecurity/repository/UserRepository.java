package com.turtles.testsecurity.repository;

import com.turtles.testsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User getOneByEmail(String email);
}
