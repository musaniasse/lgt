package com.lgt.lgtservice.dto;

import lombok.Data;

@Data
public class UserRegistrationDTO {
    private String username;

    private String password;

    private String role;
}
