package com.site.studentbranch.mapper;

import com.site.studentbranch.dto.StudentResponse;
import com.site.studentbranch.entity.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityToResponse {
    public StudentResponse entityToResponse(StudentEntity entity) {
        StudentResponse response = new StudentResponse();
        response.setName(entity.getName());
        response.setEmail(entity.getEmail());
        response.setAge(entity.getAge());
        response.setPhoneNumber(entity.getPhoneNumber());
        return response;
    }

    public List<StudentResponse> listEntityToResponse(List<StudentEntity> entity) {
        List<StudentResponse> response = new ArrayList<>();
        for(StudentEntity student : entity) {
            response.add(entityToResponse(student));
        }
        return  response;
    }
}
