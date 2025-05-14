package com.lgt.lgtservice.service;

import com.lgt.lgtservice.dto.UserRegisterDTO;
import com.lgt.lgtservice.model.User;
import com.lgt.lgtservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserRegisterMapperService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<?> uToRegDTO(UserRegisterDTO userDTO) {
        User user = new User();
        //user.setUsername(userDTO.getUsername());
        //user.setPassword(userDTO.getPassword());
        //return userRepository.save(user);
        if(userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userRepository.save(user));
    }
}
