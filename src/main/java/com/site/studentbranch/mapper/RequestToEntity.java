package com.site.studentbranch.mapper;

import com.site.studentbranch.dto.StudentRequest;
import com.site.studentbranch.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class RequestToEntity {
    public StudentEntity requestToEntity(StudentRequest request) {
        StudentEntity entity =  new StudentEntity();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setPassword(request.getPassword());
        entity.setAge(request.getAge());
        entity.setPhoneNumber(request.getPhoneNumber());
        return entity;
    }
}
