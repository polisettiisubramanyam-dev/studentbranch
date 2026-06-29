package com.site.studentbranch.mapper;

import com.site.studentbranch.dto.UpdateStudentResponse;
import com.site.studentbranch.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateEntityToResponse {
    public UpdateStudentResponse entityToResponse(StudentEntity entity) {
        UpdateStudentResponse response = new UpdateStudentResponse();
        response.setName(entity.getName());
        response.setEmail(entity.getEmail());
        response.setAge(entity.getAge());
        response.setPhoneNumber(entity.getPhoneNumber());
        return response;
    }
}