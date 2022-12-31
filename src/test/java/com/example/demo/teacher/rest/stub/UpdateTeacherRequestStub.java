package com.example.demo.teacher.rest.stub;

import com.example.demo.shared.ConstantTest;
import com.example.demo.teacher.rest.model.UpdateTeacherRequest;

public class UpdateTeacherRequestStub {

    public static UpdateTeacherRequest getUpdateTeacherRequest() {
        UpdateTeacherRequest updateTeacherRequest = new UpdateTeacherRequest();
        updateTeacherRequest.setName(ConstantTest.TEACHER_NAME_TEST);
        updateTeacherRequest.setSurname(ConstantTest.TEACHER_SURNAME_TEST);
        updateTeacherRequest.setBirthDate(ConstantTest.TEACHER_BIRTH_DATE);
        return updateTeacherRequest;
    }

    public static UpdateTeacherRequest getUpdateTeacherRequestEmpty() {
        UpdateTeacherRequest updateTeacherRequest = new UpdateTeacherRequest();
        return updateTeacherRequest;
    }
}
