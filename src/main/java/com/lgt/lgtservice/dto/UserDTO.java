package com.lgt.lgtservice.dto;

public record UserDTO(
        Long id,
        String username,
        String email,
        String role
) {
}

