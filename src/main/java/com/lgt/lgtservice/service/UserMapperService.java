package com.lgt.lgtservice.service;

import com.lgt.lgtservice.dto.UserDTO;
import com.lgt.lgtservice.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapperService {

    public UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getProfile().getFirstname() + " " + user.getProfile().getLastName(),
                user.getProfile().getEmail(),
                user.getRole()
        );
    }
}
