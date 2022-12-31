package com.example.demo.teacher.application;

import com.example.demo.shared.aplication.exception.ApplicationNotFoundException;
import com.example.demo.teacher.application.port.TeacherRepositoryPort;
import com.example.demo.teacher.domain.Teacher;
import com.example.demo.teacher.domain.TeacherBirthDate;
import com.example.demo.teacher.domain.TeacherCreateDate;
import com.example.demo.teacher.domain.TeacherId;
import com.example.demo.teacher.domain.TeacherLastUpdateDate;
import com.example.demo.teacher.domain.TeacherListPage;
import com.example.demo.teacher.domain.TeacherName;
import com.example.demo.teacher.domain.TeacherStatus;
import com.example.demo.teacher.domain.TeacherSurname;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@Service
public class TeacherService {

    private final TeacherRepositoryPort teacherRepository;

    public TeacherService(TeacherRepositoryPort teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void createTeacher(String id, String name, String surname, LocalDate birthDate) {
        Instant createDate = Instant.now();
        Teacher teacher = new Teacher(
            new TeacherId(id),
            new TeacherName(name),
            new TeacherSurname(surname),
            new TeacherBirthDate(birthDate),
            new TeacherStatus(TeacherStatus.Status.CREATED),
            new TeacherCreateDate(createDate),
            new TeacherLastUpdateDate(createDate));
        teacherRepository.save(teacher);
    }

    public void update(String idTeacher, String name, String surname, LocalDate birthDate) {
        Teacher teacher = getTeacher(idTeacher);
        teacher.update(
            new TeacherName(name),
            new TeacherSurname(surname),
            new TeacherBirthDate(birthDate));
        teacherRepository.save(teacher);
    }

    public void activate(String idTeacher) {
        Teacher teacher = getTeacher(idTeacher);
        teacher.activate();
        teacherRepository.save(teacher);
    }

    public void delete(String idTeacher) {
        Teacher teacher = getTeacher(idTeacher);
        teacher.delete();
        teacherRepository.save(teacher);
    }

    public CompletableFuture<Teacher> findById(String idTeacher) {
        return CompletableFuture
            .supplyAsync(() -> getTeacher(idTeacher));
    }

    public CompletableFuture<TeacherListPage> findAll(Integer page, Integer pageSize, String sortField, String sortDirection) {
        return CompletableFuture
            .supplyAsync(() -> teacherRepository.findAll(page, pageSize, sortField, sortDirection));
    }

    private Teacher getTeacher(String idTeacher) {
        return teacherRepository.findById(idTeacher)
            .orElseThrow(ApplicationNotFoundException::new);
    }
}
