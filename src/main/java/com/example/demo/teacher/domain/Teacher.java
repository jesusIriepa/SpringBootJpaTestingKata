package com.example.demo.teacher.domain;

import lombok.Getter;

import java.time.Instant;

@Getter
public class Teacher {
    private final TeacherId id;
    private TeacherName name;
    private TeacherSurname surname;
    private TeacherBirthDate birthDate;
    private TeacherStatus status;
    private final TeacherCreateDate createDate;
    private TeacherLastUpdateDate lastUpdateDate;

    public Teacher(
        TeacherId id,
        TeacherName name,
        TeacherSurname surname,
        TeacherBirthDate birthDate,
        TeacherStatus status,
        TeacherCreateDate createDate,
        TeacherLastUpdateDate lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.status = status;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public void update(TeacherName name, TeacherSurname surname, TeacherBirthDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.lastUpdateDate = new TeacherLastUpdateDate(Instant.now());
    }

    public void activate() {
        this.status = new TeacherStatus(TeacherStatus.Status.ACTIVE);
        this.lastUpdateDate = new TeacherLastUpdateDate(Instant.now());
    }

    public void delete() {
        this.status = new TeacherStatus(TeacherStatus.Status.INACTIVE);
        this.lastUpdateDate = new TeacherLastUpdateDate(Instant.now());
    }
}
