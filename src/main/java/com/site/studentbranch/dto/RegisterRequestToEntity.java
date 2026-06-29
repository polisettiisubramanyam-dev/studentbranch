package com.site.studentbranch.dto;

import com.site.studentbranch.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterRequestToEntity {

    @Autowired
    PasswordEncoder passwordEncoder;
    public UserEntity requestToEntity(RegisterRequest request) {
        UserEntity entity = new UserEntity();
        entity.setUserName(request.getUsername());
        entity.setPassword(passwordEncoder.encode(request.getPassword()));
        entity.setRole(request.getRole());
        return entity;
    }
}
