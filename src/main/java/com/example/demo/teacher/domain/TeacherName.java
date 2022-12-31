package com.example.demo.teacher.domain;

import com.example.demo.shared.domain.StringVO;

public class TeacherName extends StringVO {
    public static final int MIN_SIZE_NAME = 2;
    public static final int MAX_SIZE_NAME = 200;

    public TeacherName(String value) {
        super(value, MIN_SIZE_NAME, MAX_SIZE_NAME);
    }
}
