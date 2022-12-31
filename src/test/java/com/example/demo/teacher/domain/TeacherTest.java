package com.example.demo.teacher.domain;

import com.example.demo.shared.ConstantTest;
import com.example.demo.teacher.domain.stub.TeacherStub;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TeacherTest {

    @Test
    void should_create_a_teacher_ok() {
        String id = UUID.randomUUID().toString();
        Instant now = Instant.now();

        Teacher teacher = new Teacher(
            new TeacherId(id),
            new TeacherName(ConstantTest.TEACHER_NAME_TEST),
            new TeacherSurname(ConstantTest.TEACHER_SURNAME_TEST),
            new TeacherBirthDate(ConstantTest.TEACHER_BIRTH_DATE),
            new TeacherStatus(TeacherStatus.Status.CREATED),
            new TeacherCreateDate(now),
            new TeacherLastUpdateDate(now));

        assertEquals(id, teacher.getId().getValue());
        assertEquals(ConstantTest.TEACHER_NAME_TEST, teacher.getName().getValue());
        assertEquals(ConstantTest.TEACHER_SURNAME_TEST, teacher.getSurname().getValue());
        assertEquals(ConstantTest.TEACHER_BIRTH_DATE, teacher.getBirthDate().getValue());
        assertEquals(TeacherStatus.Status.CREATED.name(), teacher.getStatus().getValue());
        assertEquals(now, teacher.getCreateDate().getValue());
        assertEquals(now, teacher.getLastUpdateDate().getValue());
    }

    @Test
    void should_update_a_teacher_ok() {
        Teacher teacher = TeacherStub.getTeacher();
        Instant lastUpdateInitial = teacher.getLastUpdateDate().getValue();
        String name = "NameChange";
        String surname = "SurnameChange";
        LocalDate birthDate = LocalDate.of(1980, 12, 31);

        teacher.update(new TeacherName(name), new TeacherSurname(surname), new TeacherBirthDate(birthDate));

        assertEquals(name, teacher.getName().getValue());
        assertEquals(surname, teacher.getSurname().getValue());
        assertEquals(birthDate, teacher.getBirthDate().getValue());
        assertTrue(lastUpdateInitial.isBefore(teacher.getLastUpdateDate().getValue()));
    }

    @Test
    void should_activate_a_teacher_ok() {
        Teacher teacher = TeacherStub.getTeacher();
        Instant lastUpdateInitial = teacher.getLastUpdateDate().getValue();

        teacher.activate();

        assertEquals(TeacherStatus.Status.ACTIVE.name(), teacher.getStatus().getValue());
        assertTrue(lastUpdateInitial.isBefore(teacher.getLastUpdateDate().getValue()));
    }

    @Test
    void should_delete_a_teacher_ok() {
        Teacher teacher = TeacherStub.getTeacher();
        Instant lastUpdateInitial = teacher.getLastUpdateDate().getValue();

        teacher.delete();

        assertEquals(TeacherStatus.Status.INACTIVE.name(), teacher.getStatus().getValue());
        assertTrue(lastUpdateInitial.isBefore(teacher.getLastUpdateDate().getValue()));
    }
}