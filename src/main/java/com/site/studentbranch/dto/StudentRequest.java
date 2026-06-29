package com.site.studentbranch.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    @NotBlank(message = "The name was must to create the student..")
    private String name;

    @NotBlank(message = "The email was must to send the email...")
    @Email(message="the email was not correct")
    private String email;

    @NotBlank(message = "The password was must to login again..")
    private String password;

    @NotNull(message = "The age is requred to verify for checking you are eligible or not for some things..")
    private Integer age;

    @NotNull(message = "The phone number is must to send the information about the college...")
    private Long phoneNumber;
}
