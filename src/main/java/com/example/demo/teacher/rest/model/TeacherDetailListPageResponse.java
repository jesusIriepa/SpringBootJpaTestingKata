package com.example.demo.teacher.rest.model;

import lombok.Data;

import java.util.List;

@Data
public class TeacherDetailListPageResponse {
    private List<TeacherDetailResponse> teachers;
    private Long totalElements;
    private Integer totalPages;
}
