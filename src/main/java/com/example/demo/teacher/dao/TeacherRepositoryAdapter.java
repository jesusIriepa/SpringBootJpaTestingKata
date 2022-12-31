package com.example.demo.teacher.dao;

import com.example.demo.teacher.application.port.TeacherRepositoryPort;
import com.example.demo.teacher.dao.entity.TeacherEntity;
import com.example.demo.teacher.dao.jpa.TeacherJpaRepository;
import com.example.demo.teacher.dao.mapper.TeacherEntityMapper;
import com.example.demo.teacher.domain.Teacher;
import com.example.demo.teacher.domain.TeacherListPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TeacherRepositoryAdapter implements TeacherRepositoryPort {

    private final TeacherJpaRepository teacherJpaRepository;
    private final TeacherEntityMapper teacherEntityMapper;

    public TeacherRepositoryAdapter(TeacherJpaRepository teacherJpaRepository,
      TeacherEntityMapper teacherEntityMapper) {
        this.teacherJpaRepository = teacherJpaRepository;
        this.teacherEntityMapper = teacherEntityMapper;
    }

    @Override
    public void save(Teacher teacher) {
        teacherJpaRepository.save(teacherEntityMapper.fromDomain(teacher));
    }

    @Override
    public Optional<Teacher> findById(String idTeacher) {
        return teacherJpaRepository.findById(idTeacher)
            .map(teacherEntityMapper::toDomain);
    }

    @Override
    public TeacherListPage findAll(Integer page, Integer pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.startsWith("A") ?
            Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Page<TeacherEntity> teacherEntityPage = teacherJpaRepository.findAll(PageRequest.of(page, pageSize, sort));
        List<Teacher> teachers = teacherEntityPage.stream()
            .map(teacherEntityMapper::toDomain)
            .collect(Collectors.toList());
        return new TeacherListPage(teachers, teacherEntityPage.getTotalElements(), teacherEntityPage.getTotalPages());
    }
}
