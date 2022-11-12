package com.totemcrew.teachers.api;

import com.totemcrew.teachers.domain.service.TeacherService;
import com.totemcrew.teachers.mapping.TeacherMapper;
import com.totemcrew.teachers.resource.CreateTeacherResource;
import com.totemcrew.teachers.resource.TeacherResource;
import com.totemcrew.teachers.resource.UpdateTeacherResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teachers")
public class TeachersController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherMapper mapper;

    @GetMapping
    public List<TeacherResource> getAllTeachers() { return mapper.modelListToResource(teacherService.getAll()); }

    @GetMapping("{teacherId}")
    public TeacherResource getTeacherById(@PathVariable("teacherId") Long teacherId) {
        return mapper.toResource(teacherService.getById(teacherId));
    }

    @PostMapping("")
    public TeacherResource createUser(@RequestBody CreateTeacherResource request) {
        return mapper.toResource(teacherService.create(mapper.toModel(request)));
    }

    @PutMapping("{teacherId}")
    public TeacherResource updateTeacher(@PathVariable Long teacherId, @RequestBody UpdateTeacherResource request) {
        return mapper.toResource(teacherService.update(teacherId, mapper.toModel(request)));
    }

    @DeleteMapping("{teacherId}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long teacherId) {
        return teacherService.delete(teacherId);
    }
}
