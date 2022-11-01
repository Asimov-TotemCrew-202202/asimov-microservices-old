package com.totemcrew.teacherservice.teachers.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TeacherService {
    List<com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher> getAll();
    Page<com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher> getAll(Pageable pageable);
    com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher getById(Long teacherId);
    com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher create(com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher teacher);
    com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher update(Long teacherId, com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher teacher);
    ResponseEntity<?> delete(Long teacherId);
}
