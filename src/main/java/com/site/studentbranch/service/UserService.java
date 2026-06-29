package com.site.studentbranch.service;

import com.site.studentbranch.dto.RegisterRequest;
import com.site.studentbranch.dto.RegisterRequestToEntity;
import com.site.studentbranch.entity.UserEntity;
import com.site.studentbranch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    RegisterRequestToEntity requestToEntity;

    public void register(RegisterRequest request) {
        UserEntity user = requestToEntity.requestToEntity(request);
        repository.save(user);
    }
}
