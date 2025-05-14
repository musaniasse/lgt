package com.lgt.lgtservice.repository;

import com.lgt.lgtservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByProfileEmail(String email);
    Optional<User> findByUsername(String username);
}
