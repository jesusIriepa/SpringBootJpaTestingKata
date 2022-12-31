package com.example.demo.subject.rest.model;

import lombok.Data;

@Data
public class CreateSubjectRequest {
    private String id;
    private String name;
    private String description;
}
