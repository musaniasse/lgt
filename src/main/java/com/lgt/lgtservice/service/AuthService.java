package com.lgt.lgtservice.service;

import com.lgt.lgtservice.dto.UserRegisterDTO;
import com.lgt.lgtservice.model.User;
import com.lgt.lgtservice.model.Vehicule;
import com.lgt.lgtservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(UserRegisterDTO registrationDTO) {
        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

        String role = (registrationDTO.getRole() != null) ? registrationDTO.getRole() : "ROLE_USER";
        user.setRole(role);

        user.setVehiculeList(new ArrayList<>());
        user.setProfile(null);

        /*userRepository.save(user);*/
        if(userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userRepository.save(user));
    }
}
