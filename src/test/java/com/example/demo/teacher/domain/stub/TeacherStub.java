package com.example.demo.teacher.domain.stub;

import com.example.demo.shared.ConstantTest;
import com.example.demo.teacher.domain.Teacher;
import com.example.demo.teacher.domain.TeacherBirthDate;
import com.example.demo.teacher.domain.TeacherCreateDate;
import com.example.demo.teacher.domain.TeacherId;
import com.example.demo.teacher.domain.TeacherLastUpdateDate;
import com.example.demo.teacher.domain.TeacherName;
import com.example.demo.teacher.domain.TeacherStatus;
import com.example.demo.teacher.domain.TeacherSurname;

import java.time.Instant;
import java.util.UUID;

public class TeacherStub {

    public static Teacher getTeacher(){
        Instant now = Instant.now();
        return new Teacher(
            new TeacherId(UUID.randomUUID().toString()),
            new TeacherName(ConstantTest.TEACHER_NAME_TEST),
            new TeacherSurname(ConstantTest.TEACHER_SURNAME_TEST),
            new TeacherBirthDate(ConstantTest.TEACHER_BIRTH_DATE),
            new TeacherStatus(TeacherStatus.Status.CREATED),
            new TeacherCreateDate(now),
            new TeacherLastUpdateDate(now));
    }
}
