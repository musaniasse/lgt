package com.lgt.lgtservice.controller;

import com.lgt.lgtservice.model.User;
import com.lgt.lgtservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        return userService.deleteUser(id);
    }
}