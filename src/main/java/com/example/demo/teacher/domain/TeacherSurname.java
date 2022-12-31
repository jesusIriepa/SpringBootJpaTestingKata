package com.example.demo.teacher.domain;

import com.example.demo.shared.domain.StringVO;

public class TeacherSurname extends StringVO {
    public static final int MIN_SIZE_SURNAME = 2;
    public static final int MAX_SIZE_SURNAME = 200;

    public TeacherSurname(String value) {
        super(value, MIN_SIZE_SURNAME, MAX_SIZE_SURNAME);
    }
}
