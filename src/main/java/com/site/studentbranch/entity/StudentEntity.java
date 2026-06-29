package com.site.studentbranch.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="student")
public class StudentEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    private String name;

    private String email;

    private String password;

    private Integer age;

    @Column(name="phone_number")
    private Long phoneNumber;

}
