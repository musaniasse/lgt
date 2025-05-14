package com.lgt.lgtservice.service;

import com.lgt.lgtservice.model.User;
import com.lgt.lgtservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        return optionalUser.get();
    }

    public User addUser(User user) {
        Optional<User> optionalUser = userRepository.findByProfileEmail(user.getProfile().getEmail());
        if (optionalUser.isPresent()) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }

    public User updateUser(long id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User existingUser = optionalUser.get();
        existingUser.setUsername(user.getUsername());
        existingUser.setRole(user.getRole());
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }

    public String deleteUser(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
        return "User deleted successfully";
    }
}
