package com.site.studentbranch.mapper;

import com.site.studentbranch.dto.UpdateStudentRequest;
import com.site.studentbranch.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateRequestToEntity {
    public StudentEntity requestToEntity(UpdateStudentRequest request) {
        StudentEntity entity =  new StudentEntity();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setPassword(request.getPassword());
        entity.setAge(request.getAge());
        entity.setPhoneNumber(request.getPhoneNumber());
        return entity;
    }
}
