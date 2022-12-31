package com.example.demo.subject.rest.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CreateSubjectClassRequest {
    private String id;
    private String idTeacher;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocationRequest locationRequest;
}
