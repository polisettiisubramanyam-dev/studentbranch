package com.site.studentbranch.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    Integer id;

    private String name;

    private String email;

    private Integer age;

    private Long phoneNumber;
}
