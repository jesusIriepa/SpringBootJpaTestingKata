package com.example.demo.teacher.dao.mapper;

import com.example.demo.teacher.dao.entity.TeacherEntity;
import com.example.demo.teacher.dao.entity.stub.TeacherEntityStub;
import com.example.demo.teacher.domain.Teacher;
import com.example.demo.teacher.domain.stub.TeacherStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherEntityMapperTest {

    private final TeacherEntityMapper teacherEntityMapper = new TeacherEntityMapper();

    @Test
    void sholud_mapper_domain_from_entity_ok() {
        TeacherEntity teacherEntity = TeacherEntityStub.getTeacherEntity();
        Teacher teacher = teacherEntityMapper.toDomain(teacherEntity);
        assertEquals(teacherEntity.getId(), teacher.getId().getValue());
        assertEquals(teacherEntity.getName(), teacher.getName().getValue());
        assertEquals(teacherEntity.getSurname(), teacher.getSurname().getValue());
        assertEquals(teacherEntity.getBirthDate(), teacher.getBirthDate().getValue());
        assertEquals(teacherEntity.getStatus(), teacher.getStatus().getValue());
        assertEquals(teacherEntity.getCreateDate(), teacher.getCreateDate().getValue());
        assertEquals(teacherEntity.getLastUpdateDate(), teacher.getLastUpdateDate().getValue());
    }

    @Test
    void should_mapper_entity_from_domain_ok(){
        Teacher teacher = TeacherStub.getTeacher();
        TeacherEntity teacherEntity = teacherEntityMapper.fromDomain(teacher);
        assertEquals(teacher.getId().getValue(), teacherEntity.getId());
        assertEquals(teacher.getName().getValue(), teacherEntity.getName());
        assertEquals(teacher.getSurname().getValue(), teacherEntity.getSurname());
        assertEquals(teacher.getBirthDate().getValue(), teacherEntity.getBirthDate());
        assertEquals(teacher.getStatus().getValue(), teacherEntity.getStatus());
        assertEquals(teacher.getCreateDate().getValue(), teacherEntity.getCreateDate());
        assertEquals(teacher.getLastUpdateDate().getValue(), teacherEntity.getLastUpdateDate());
    }
}