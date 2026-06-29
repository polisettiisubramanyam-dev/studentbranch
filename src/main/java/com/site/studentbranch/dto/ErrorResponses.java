package com.site.studentbranch.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class ErrorResponses {
    private String path;
    private String message;
    private HttpStatus status;
    private LocalDateTime datetime;

    public ErrorResponses(String path, String message, HttpStatus status, LocalDateTime datetime) {
        this.path = path;
        this.message = message;
        this.status = status;
        this.datetime = datetime;
    }
}
