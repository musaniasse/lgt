package com.lgt.lgtservice.dto;

import lombok.Data;

@Data
public class UserRegisterDTO {
    private Long id;
    private String username;
    private String password;
    private String role;
}
