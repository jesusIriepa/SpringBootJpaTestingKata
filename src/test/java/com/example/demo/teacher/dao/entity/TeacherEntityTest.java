package com.example.demo.teacher.dao.entity;

import com.example.demo.shared.ConstantTest;
import com.example.demo.teacher.dao.entity.stub.TeacherEntityStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TeacherEntityTest {

    @Test
    void should_create_a_teacher_entity_ok() {
        TeacherEntity teacher = TeacherEntityStub.getTeacherEntity();
        assertNotNull(teacher.getId());
        assertEquals(ConstantTest.TEACHER_NAME_TEST, teacher.getName());
        assertEquals(ConstantTest.TEACHER_SURNAME_TEST, teacher.getSurname());
        assertEquals(ConstantTest.TEACHER_BIRTH_DATE, teacher.getBirthDate());
        assertNotNull(teacher.getStatus());
        assertEquals(ConstantTest.TEST_CREATE_DATE, teacher.getCreateDate());
        assertEquals(ConstantTest.TEST_UPDATE_DATE, teacher.getLastUpdateDate());
    }
}