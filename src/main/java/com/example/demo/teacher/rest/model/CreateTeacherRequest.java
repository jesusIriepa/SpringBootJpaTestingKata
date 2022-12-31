package com.example.demo.teacher.rest.model;

import com.example.demo.teacher.domain.TeacherName;
import com.example.demo.teacher.domain.TeacherSurname;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class CreateTeacherRequest {
    @NotBlank
    private String id;
    @NotBlank
    @Size(min = TeacherName.MIN_SIZE_NAME, max = TeacherName.MAX_SIZE_NAME)
    private String name;
    @NotBlank
    @Size(min = TeacherSurname.MIN_SIZE_SURNAME, max = TeacherSurname.MAX_SIZE_SURNAME)
    private String surname;
    @NotNull
    private LocalDate birthDate;
}
