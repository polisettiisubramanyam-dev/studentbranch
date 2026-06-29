package com.site.studentbranch.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "The username is must to register")
    private String username;

    @NotBlank(message = "The password is must to register")
    private String password;

    @NotBlank(message = "The role is must to register..")
    private String role;
}
