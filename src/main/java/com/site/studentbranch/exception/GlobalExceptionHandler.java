package com.site.studentbranch.exception;

import com.site.studentbranch.dto.ErrorResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponses> studentNotFoundException(
            StudentNotFoundException ex, HttpServletRequest request) {
        ErrorResponses responses = new ErrorResponses(
                request.getRequestURI(),ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return ResponseEntity.badRequest().body(responses);
    }
}
