package com.example.demo.teacher.rest.stub;

import com.example.demo.shared.ConstantTest;
import com.example.demo.teacher.rest.model.CreateTeacherRequest;

import java.util.UUID;

public class CreateTeacherRequestStub {

    public static CreateTeacherRequest getCreateTeacherRequestEmpty() {
        CreateTeacherRequest createTeacherRequest = new CreateTeacherRequest();
        return createTeacherRequest;
    }

    public static CreateTeacherRequest getCreateTeacherRequest() {
        CreateTeacherRequest createTeacherRequest = new CreateTeacherRequest();
        createTeacherRequest.setId(UUID.randomUUID().toString());
        createTeacherRequest.setName(ConstantTest.TEACHER_NAME_TEST);
        createTeacherRequest.setSurname(ConstantTest.TEACHER_SURNAME_TEST);
        createTeacherRequest.setBirthDate(ConstantTest.TEACHER_BIRTH_DATE);
        return createTeacherRequest;
    }
}
