package com.example.demo.teacher.dao.entity.stub;

import com.example.demo.shared.ConstantTest;
import com.example.demo.teacher.dao.entity.TeacherEntity;
import com.example.demo.teacher.domain.TeacherStatus;

import java.util.UUID;

public class TeacherEntityStub {

    public static TeacherEntity getTeacherEntity(){
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(UUID.randomUUID().toString());
        teacherEntity.setName(ConstantTest.TEACHER_NAME_TEST);
        teacherEntity.setSurname(ConstantTest.TEACHER_SURNAME_TEST);
        teacherEntity.setBirthDate(ConstantTest.TEACHER_BIRTH_DATE);
        teacherEntity.setStatus(TeacherStatus.Status.CREATED.name());
        teacherEntity.setCreateDate(ConstantTest.TEST_CREATE_DATE);
        teacherEntity.setLastUpdateDate(ConstantTest.TEST_UPDATE_DATE);
        return teacherEntity;
    }
}
