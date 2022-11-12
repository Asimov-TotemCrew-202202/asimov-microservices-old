package com.totemcrew.teachers.domain.service;

import com.totemcrew.teachers.domain.model.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAll();
    Page<Teacher> getAll(Pageable pageable);
    Teacher getById(Long teacherId);
    Teacher create(Teacher teacher);
    Teacher update(Long teacherId, Teacher teacher);
    ResponseEntity<?> delete(Long teacherId);
}
