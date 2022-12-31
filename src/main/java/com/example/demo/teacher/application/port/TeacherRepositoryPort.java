package com.example.demo.teacher.application.port;

import com.example.demo.teacher.domain.Teacher;
import com.example.demo.teacher.domain.TeacherListPage;

import java.util.Optional;

public interface TeacherRepositoryPort {

    void save(Teacher teacher);

    Optional<Teacher> findById(String idTeacher);

    TeacherListPage findAll(Integer page, Integer pageSize, String sortField, String sortDirection);
}
