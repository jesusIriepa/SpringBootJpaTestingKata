package com.example.demo.shared.rest;

import com.example.demo.shared.aplication.exception.ApplicationNotFoundException;
import com.example.demo.shared.domain.exception.DomainArgumentException;
import com.example.demo.shared.rest.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class RestErrorController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("Rest Method Argument Exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
            .cause(e.getMessage())
            .detail(e.getBindingResult().getFieldErrors().stream()
                .map(objectError -> objectError.getField() + " - >" + objectError.getDefaultMessage())
                .collect(Collectors.joining(" || ")))
            .httpCode(HttpStatus.BAD_REQUEST.value())
            .timestamp(LocalDateTime.now())
            .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(DomainArgumentException.class)
    public ResponseEntity<ErrorResponse> handleDomainArgumentException(DomainArgumentException e) {
        log.error("Rest Domain Argument Exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
            .cause("Request not allowed by the application. Business validation error.")
            .detail(e.getField() + " -> " + e.getCauseException())
            .httpCode(HttpStatus.BAD_REQUEST.value())
            .timestamp(LocalDateTime.now())
            .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(ApplicationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleApplicationNotFoundException(ApplicationNotFoundException e) {
        log.error("Application Not Found Exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
            .cause("Element not found. Business validation error.")
            .detail("The element requested not exists in the system.")
            .httpCode(HttpStatus.NOT_FOUND.value())
            .timestamp(LocalDateTime.now())
            .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception e) {
        log.error("Rest Global Exception", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
            .cause(e.getMessage())
            .detail(Arrays.stream(e.getStackTrace())
                .limit(5)
                .map(StackTraceElement::toString)
                .collect(Collectors.joining("\n")))
            .httpCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .timestamp(LocalDateTime.now())
            .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
