package com.example.demo.teacher.rest.mapper;

import com.example.demo.teacher.domain.Teacher;
import com.example.demo.teacher.domain.TeacherListPage;
import com.example.demo.teacher.rest.model.TeacherDetailResponse;
import com.example.demo.teacher.rest.model.TeacherDetailListPageResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Collectors;

@Component
public class TeacherDetailMapper {

    public TeacherDetailListPageResponse fromListPageDomainToListPageResponse(TeacherListPage teacherListPage) {
        TeacherDetailListPageResponse teacherDetailListPageResponse = new TeacherDetailListPageResponse();
        teacherDetailListPageResponse.setTeachers(
            teacherListPage.getTeachers().stream().map(this::fromDomainToResponse).collect(Collectors.toList()));
        teacherDetailListPageResponse.setTotalElements(teacherListPage.getTotalElements());
        teacherDetailListPageResponse.setTotalPages(teacherListPage.getTotalPages());
        return teacherDetailListPageResponse;
    }

    public TeacherDetailResponse fromDomainToResponse(Teacher teacher) {
        TeacherDetailResponse teacherDetailResponse = new TeacherDetailResponse();
        teacherDetailResponse.setId(teacher.getId().getValue());
        teacherDetailResponse.setName(teacher.getName().getValue());
        teacherDetailResponse.setSurname(teacher.getSurname().getValue());
        teacherDetailResponse.setBirthDate(teacher.getBirthDate().getValue());
        teacherDetailResponse.setStatus(teacher.getStatus().getValue());
        teacherDetailResponse.setCreationDate(LocalDateTime.ofInstant(
            teacher.getCreateDate().getValue(), ZoneId.systemDefault()));
        teacherDetailResponse.setLastUpdateDate(LocalDateTime.ofInstant(
            teacher.getLastUpdateDate().getValue(), ZoneId.systemDefault()));
        return teacherDetailResponse;
    }
}
