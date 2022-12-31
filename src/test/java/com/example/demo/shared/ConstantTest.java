package com.example.demo.shared;

import java.time.Instant;
import java.time.LocalDate;

public interface ConstantTest {

    String TEACHER_NAME_TEST = "Teacher";
    String TEACHER_SURNAME_TEST = "Test";
    LocalDate TEACHER_BIRTH_DATE = LocalDate.of(1990, 1, 1);
    String UPDATE_TEACHER_ID1_CREATED = "891d777f-c3d3-4c2d-86e1-1c5173e114ee";
    String UPDATE_TEACHER_ID2_ACTIVE = "67a4c0bf-85b4-469a-83e6-123062c70a7d";
    String UPDATE_TEACHER_ID3_INACTIVE = "87619cee-9568-49db-82a3-a354118b9274";
    Instant TEST_CREATE_DATE = Instant.parse("2022-12-03T22:15:30.00Z");
    Instant TEST_UPDATE_DATE = Instant.parse("2022-12-06T21:15:10.00Z");
}
