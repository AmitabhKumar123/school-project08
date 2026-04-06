package com.school.exception;

import com.school.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<String>> handleException(RuntimeException ex) {

        ApiResponse<String> response =
                new ApiResponse<>(400, ex.getMessage(), null);

        return ResponseEntity.badRequest().body(response);
    }
}