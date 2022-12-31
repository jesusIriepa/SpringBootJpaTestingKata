package com.example.demo.teacher.application;

import com.example.demo.shared.ConstantTest;
import com.example.demo.shared.aplication.exception.ApplicationNotFoundException;
import com.example.demo.teacher.application.port.TeacherRepositoryPort;
import com.example.demo.teacher.domain.stub.TeacherStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeacherServiceTest {

    private TeacherRepositoryPort teacherRepository = Mockito.mock(TeacherRepositoryPort.class);
    private TeacherService teacherService = new TeacherService(teacherRepository);

    @Test
    void should_create_a_new_teacher_ok() {
        teacherService.createTeacher(
            UUID.randomUUID().toString(),
            ConstantTest.TEACHER_NAME_TEST,
            ConstantTest.TEACHER_SURNAME_TEST,
            ConstantTest.TEACHER_BIRTH_DATE);
        verify(teacherRepository, times(1)).save(any());
    }

    @Test
    void should_update_a_teacher_ok() {
        when(teacherRepository.findById(any())).thenReturn(Optional.of(TeacherStub.getTeacher()));
        teacherService.update(
            UUID.randomUUID().toString(),
            ConstantTest.TEACHER_NAME_TEST,
            ConstantTest.TEACHER_SURNAME_TEST,
            ConstantTest.TEACHER_BIRTH_DATE);
        verify(teacherRepository, times(1)).save(any());
    }

    @Test
    void should_throw_not_found_exception_updating_a_teacher_that_not_exists() {
        String id = UUID.randomUUID().toString();
        when(teacherRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(ApplicationNotFoundException.class,
            ()-> teacherService.update(
                id,
                ConstantTest.TEACHER_NAME_TEST,
                ConstantTest.TEACHER_SURNAME_TEST,
                ConstantTest.TEACHER_BIRTH_DATE));
        verify(teacherRepository, never()).save(any());
    }

    @Test
    void should_activate_a_teacher_ok() {
        when(teacherRepository.findById(any())).thenReturn(Optional.of(TeacherStub.getTeacher()));
        teacherService.activate(UUID.randomUUID().toString());
        verify(teacherRepository, times(1)).save(any());
    }

    @Test
    void should_throw_not_found_exception_activating_a_teacher_that_not_exists() {
        String id = UUID.randomUUID().toString();
        when(teacherRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(ApplicationNotFoundException.class,
            ()-> teacherService.activate(id));
        verify(teacherRepository, never()).save(any());
    }

    @Test
    void should_delete_a_teacher_ok() {
        when(teacherRepository.findById(any())).thenReturn(Optional.of(TeacherStub.getTeacher()));
        teacherService.delete(UUID.randomUUID().toString());
        verify(teacherRepository, times(1)).save(any());
    }

    @Test
    void should_throw_not_found_exception_deleting_a_teacher_that_not_exists() {
        String id = UUID.randomUUID().toString();
        when(teacherRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(ApplicationNotFoundException.class,
            ()-> teacherService.delete(id));
        verify(teacherRepository, never()).save(any());
    }
}