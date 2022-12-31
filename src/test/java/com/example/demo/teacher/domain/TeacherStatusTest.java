package com.example.demo.teacher.domain;

import com.example.demo.shared.domain.exception.DomainArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TeacherStatusTest {

    @Test
    void should_create_a_statusvo_ok() {
        TeacherStatus.Status status = TeacherStatus.Status.ACTIVE;
        TeacherStatus teacherStatus = new TeacherStatus(status);
        assertEquals(status.name(), teacherStatus.getValue());
    }

    @Test
    void should_create_a_statusvo_ok_with_name() {
        String status = TeacherStatus.Status.ACTIVE.name();
        TeacherStatus teacherStatus = new TeacherStatus(status);
        assertEquals(status, teacherStatus.getValue());
    }

    @Test
    void should_throw_domain_exception_null_status() {
        DomainArgumentException exception = assertThrows(DomainArgumentException.class,
            () -> new TeacherStatus((String) null));
        assertTrue(exception.getCauseException().contains("Null value is not allowed"));
    }

    @Test
    void should_throw_domain_exception_not_allowed_status() {
        DomainArgumentException exception = assertThrows(DomainArgumentException.class,
            () -> new TeacherStatus("Bad status"));
        assertTrue(exception.getCauseException().contains("is not a valid Status"));
    }
}