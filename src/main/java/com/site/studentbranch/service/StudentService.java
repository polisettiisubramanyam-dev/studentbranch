package com.site.studentbranch.service;

import com.site.studentbranch.dto.StudentRequest;
import com.site.studentbranch.dto.StudentResponse;
import com.site.studentbranch.dto.UpdateStudentRequest;
import com.site.studentbranch.dto.UpdateStudentResponse;
import com.site.studentbranch.entity.StudentEntity;
import com.site.studentbranch.exception.StudentNotFoundException;
import com.site.studentbranch.mapper.EntityToResponse;
import com.site.studentbranch.mapper.RequestToEntity;
import com.site.studentbranch.mapper.UpdateEntityToResponse;
import com.site.studentbranch.mapper.UpdateRequestToEntity;
import com.site.studentbranch.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    @Autowired
    RequestToEntity requestToEntity;

    @Autowired
    UpdateRequestToEntity updateRequestToEntity;

    @Autowired
    UpdateEntityToResponse updateEntityToResponse;

    @Autowired
    EntityToResponse entityToResponse;

    public StudentResponse create(StudentRequest request) {
            StudentEntity student = requestToEntity.requestToEntity(request);
            student.setCreatedAt(LocalDateTime.now());
            repository.save(student);
            return entityToResponse.entityToResponse(student);
    }

    public UpdateStudentResponse update(int id, UpdateStudentRequest request) {

        Optional<StudentEntity> optionalStudent = repository.findById(id);

        if (optionalStudent.isPresent()) {

            StudentEntity student = optionalStudent.get();

            student.setName(request.getName());
            student.setEmail(request.getEmail());
            student.setPassword(request.getPassword());
            student.setAge(request.getAge());
            student.setPhoneNumber(request.getPhoneNumber());

            repository.save(student);

            return updateEntityToResponse.entityToResponse(student);

        } else {
            throw new StudentNotFoundException(
                    "The student was not present with given id...");
        }
    }

    public StudentResponse findById(int id) {
        Optional<StudentEntity> optionalStudent = repository.findById(id);
        if(optionalStudent.isPresent()) {
            return entityToResponse.entityToResponse(optionalStudent.get());
        } else {
            throw new StudentNotFoundException("The student was not found by given id...");
        }
    }

    public List<StudentResponse> findAll() {
        List<StudentEntity> students = repository.findAll();
        List<StudentResponse> responses = entityToResponse.listEntityToResponse(students);
        return responses;
    }

    public String deleteById(int id) {
        Optional<StudentEntity> optionalStudent = repository.findById(id);
        if(optionalStudent.isPresent()) {
            repository.deleteById(id);
            return "Student removed from DB successfully...";
        } else {
            throw new StudentNotFoundException("The data was not found for given id...");
        }
    }
}
