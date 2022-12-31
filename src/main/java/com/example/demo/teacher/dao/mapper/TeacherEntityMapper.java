package com.example.demo.teacher.dao.mapper;

import com.example.demo.teacher.dao.entity.TeacherEntity;
import com.example.demo.teacher.domain.Teacher;
import com.example.demo.teacher.domain.TeacherBirthDate;
import com.example.demo.teacher.domain.TeacherCreateDate;
import com.example.demo.teacher.domain.TeacherId;
import com.example.demo.teacher.domain.TeacherLastUpdateDate;
import com.example.demo.teacher.domain.TeacherName;
import com.example.demo.teacher.domain.TeacherStatus;
import com.example.demo.teacher.domain.TeacherSurname;
import org.springframework.stereotype.Component;

@Component
public class TeacherEntityMapper {

    public TeacherEntity fromDomain(Teacher teacher) {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(teacher.getId().getValue());
        teacherEntity.setName(teacher.getName().getValue());
        teacherEntity.setSurname(teacher.getSurname().getValue());
        teacherEntity.setBirthDate(teacher.getBirthDate().getValue());
        teacherEntity.setStatus(teacher.getStatus().getValue());
        teacherEntity.setCreateDate(teacher.getCreateDate().getValue());
        teacherEntity.setLastUpdateDate(teacher.getLastUpdateDate().getValue());
        return teacherEntity;
    }

    public Teacher toDomain(TeacherEntity teacherEntity) {
        return new Teacher(
            new TeacherId(teacherEntity.getId()),
            new TeacherName(teacherEntity.getName()),
            new TeacherSurname(teacherEntity.getSurname()),
            new TeacherBirthDate(teacherEntity.getBirthDate()),
            new TeacherStatus(teacherEntity.getStatus()),
            new TeacherCreateDate(teacherEntity.getCreateDate()),
            new TeacherLastUpdateDate(teacherEntity.getLastUpdateDate()));

    }
}
