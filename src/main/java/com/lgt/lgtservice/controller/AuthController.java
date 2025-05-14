package com.lgt.lgtservice.controller;

import com.lgt.lgtservice.dto.UserRegisterDTO;
import com.lgt.lgtservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterDTO registrationDTO){
        authService.createUser(registrationDTO);
        return ResponseEntity.ok("User registered successfully!");
    }
}
