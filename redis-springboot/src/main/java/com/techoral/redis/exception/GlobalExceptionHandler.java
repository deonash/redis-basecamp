package com.techoral.redis.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    
@ExceptionHandler(Exception.class)
public ResponseEntity<ApiError> handleGenericError(Exception ex, HttpServletRequest request) {

    log.error("Unhandled exception at {}: {}", request.getRequestURI(), ex.getMessage(), ex);


    ApiError error = new ApiError(LocalDateTime.now(), 500, "Internal Server Error",
                                   ex.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
}

}
