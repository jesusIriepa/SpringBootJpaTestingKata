package com.example.demo.teacher.domain;

import com.example.demo.shared.domain.exception.DomainArgumentException;
import com.example.demo.shared.domain.DateVO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TeacherBirthDate extends DateVO {

    public TeacherBirthDate(LocalDate value) {
        super(value);
        guard();
    }

    private void guard() {
        LocalDate minBirthDate = LocalDate.now().minus(18, ChronoUnit.YEARS);
        if(getValue().isAfter(minBirthDate)) {
            throw new DomainArgumentException("Teacher BirthDate", "Teacher must be at least 18 years old");
        }
    }
}
