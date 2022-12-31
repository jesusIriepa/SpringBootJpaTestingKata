package com.example.demo.teacher.dao.jpa;

import com.example.demo.teacher.dao.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherJpaRepository extends JpaRepository<TeacherEntity, String> {
}
