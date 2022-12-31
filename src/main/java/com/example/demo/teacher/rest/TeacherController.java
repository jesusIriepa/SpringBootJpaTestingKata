package com.example.demo.teacher.rest;

import com.example.demo.teacher.application.TeacherService;
import com.example.demo.teacher.rest.mapper.TeacherDetailMapper;
import com.example.demo.teacher.rest.model.CreateTeacherRequest;
import com.example.demo.teacher.rest.model.TeacherDetailListPageResponse;
import com.example.demo.teacher.rest.model.TeacherDetailResponse;
import com.example.demo.teacher.rest.model.UpdateTeacherRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherDetailMapper teacherDetailMapper;

    public TeacherController(TeacherService teacherService, TeacherDetailMapper teacherDetailMapper) {
        this.teacherService = teacherService;
        this.teacherDetailMapper = teacherDetailMapper;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CreateTeacherRequest createTeacherRequest) {
        log.info("Create Teacher Request: {}", createTeacherRequest);
        teacherService.createTeacher(
            createTeacherRequest.getId(),
            createTeacherRequest.getName(),
            createTeacherRequest.getSurname(),
            createTeacherRequest.getBirthDate());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idTeacher}")
    public ResponseEntity<Void> update(@PathVariable String idTeacher,
     @RequestBody UpdateTeacherRequest updateTeacherRequest) {
        log.info("Update Teacher Request: {} -> {}", idTeacher, updateTeacherRequest);
        teacherService.update(
            idTeacher,
            updateTeacherRequest.getName(),
            updateTeacherRequest.getSurname(),
            updateTeacherRequest.getBirthDate());
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{idTeacher}/activate")
    public ResponseEntity<Void> activate(@PathVariable String idTeacher) {
        log.info("Activate Teacher Request: {}", idTeacher);
        teacherService.activate(idTeacher);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idTeacher}")
    public ResponseEntity<Void> delete(@PathVariable String idTeacher) {
        teacherService.delete(idTeacher);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<TeacherDetailListPageResponse>> getAll(
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize,
        @RequestParam(value = "sort_field", defaultValue = "name") String sortField,
        @RequestParam(value = "sort_direction", defaultValue = "A") String sortDirection) {
        return teacherService.findAll(page, pageSize, sortField, sortDirection)
            .thenApply(this.teacherDetailMapper::fromListPageDomainToListPageResponse)
            .thenApply(ResponseEntity::ok);
    }

    @GetMapping("/{idTeacher}")
    public CompletableFuture<ResponseEntity<TeacherDetailResponse>> findById(@PathVariable String idTeacher) {
        return teacherService.findById(idTeacher)
            .thenApply(this.teacherDetailMapper::fromDomainToResponse)
            .thenApply(ResponseEntity::ok);
    }
}
