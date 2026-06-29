package com.site.studentbranch.controller;

import com.site.studentbranch.dto.*;
import com.site.studentbranch.service.CustomUserDetailsService;
import com.site.studentbranch.service.StudentService;
import com.site.studentbranch.service.UserService;
import com.site.studentbranch.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Autowired
    JwtUtil util;

    @PostMapping
    public ResponseEntity<StudentResponse> create(
           @Valid @RequestBody StudentRequest request) {
        StudentResponse response = service.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateStudentResponse> update(
            @PathVariable int id,@Valid @RequestBody UpdateStudentRequest request) {
        UpdateStudentResponse response = service.update(id, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable  int id) {
        StudentResponse response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> findAll() {
        List<StudentResponse> response = service.findAll();
        return  ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByid(@PathVariable  int id) {
        String stats = service.deleteById(id);
        return ResponseEntity.ok(stats);
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) {
        userService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );

        String token = util.generateToke(request.getUserName());

        LoginResponse response = new LoginResponse(request.getUserName(), token);
        return ResponseEntity.ok(response);
    }
}
