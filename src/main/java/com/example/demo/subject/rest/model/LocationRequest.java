package com.example.demo.subject.rest.model;

import lombok.Data;

@Data
public class LocationRequest {
    private String building;
    private Integer floor;
    private String className;
}
