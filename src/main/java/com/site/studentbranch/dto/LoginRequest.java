package com.site.studentbranch.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = "The userName must required to login..")
    private String userName;

    @NotBlank(message = "The password was mandatory to login...")
    private String password;
}
