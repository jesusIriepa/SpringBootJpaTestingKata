package com.example.demo.teacher.domain;

import com.example.demo.shared.domain.exception.DomainArgumentException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TeacherBirthDateTest {

    @Test
    void should_create_a_valid_birthdatevo() {
        LocalDate localDate = LocalDate.now().minus(18, ChronoUnit.YEARS);
        TeacherBirthDate teacherBirthDate = new TeacherBirthDate(localDate);
        assertEquals(localDate, teacherBirthDate.getValue());
    }

    @Test
    void should_throws_domain_exception_birthdate_less_18_years() {
        LocalDate localDate = LocalDate.now()
            .minus(18, ChronoUnit.YEARS)
            .plus(1, ChronoUnit.DAYS);
        DomainArgumentException exception = assertThrows(DomainArgumentException.class,
            ()-> new TeacherBirthDate(localDate));
        assertTrue(exception.getCauseException().contains("at least 18 years old"));
    }

}