package com.example.demo.teacher.dao.jpa;

import com.example.demo.teacher.dao.entity.TeacherEntity;
import com.example.demo.teacher.dao.entity.stub.TeacherEntityStub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class TeacherJpaRepositoryTest {

    @Autowired
    private TeacherJpaRepository teacherJpaRepository;

    @Test
    void should_save_and_find_a_teacher_entity_ok() {
        TeacherEntity teacherEntity = TeacherEntityStub.getTeacherEntity();

        teacherJpaRepository.save(teacherEntity);
        Optional<TeacherEntity> optionalTeacherEntity = teacherJpaRepository.findById(teacherEntity.getId());

        assertTrue(optionalTeacherEntity.isPresent());
        TeacherEntity teacherEntityStored = optionalTeacherEntity.get();
        assertEquals(teacherEntity, teacherEntityStored);
    }

}