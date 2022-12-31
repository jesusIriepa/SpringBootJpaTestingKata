package com.example.demo.teacher.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TEACHER")
public class TeacherEntity {
    @Id
    @Column(name = "ID", length = 100)
    private String id;

    @Column(name = "NAME", length = 200, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 200, nullable = false)
    private String surname;

    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDate birthDate;

    @Column(name = "STATUS", length = 100, nullable = false)
    private String status;

    @Column(name = "CREATE_DATE", nullable = false)
    private Instant createDate;

    @Column(name = "LAST_UPDATE_DATE", nullable = false)
    private Instant lastUpdateDate;
}
