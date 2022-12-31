package com.example.demo.teacher.rest.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TeacherDetailResponse {
    private String id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String status;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;
}
