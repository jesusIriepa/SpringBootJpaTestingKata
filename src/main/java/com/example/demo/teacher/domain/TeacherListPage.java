package com.example.demo.teacher.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class TeacherListPage {
    private final List<Teacher> teachers;
    private final Long totalElements;
    private final Integer totalPages;

    public TeacherListPage(List<Teacher> teachers, Long totalElements, Integer totalPages) {
        this.teachers = teachers;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }
}
