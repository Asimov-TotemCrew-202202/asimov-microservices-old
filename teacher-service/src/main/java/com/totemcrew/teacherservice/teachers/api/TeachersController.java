package com.totemcrew.teacherservice.teachers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teachers")
public class TeachersController {

    @Autowired
    private com.totemcrew.teacherservice.teachers.domain.service.TeacherService teacherService;

    @Autowired
    private com.totemcrew.teacherservice.teachers.mapping.TeacherMapper mapper;

    @GetMapping
    public List<com.totemcrew.teacherservice.teachers.resource.TeacherResource> getAllTeachers() { return mapper.modelListToResource(teacherService.getAll()); }

    @GetMapping("{teacherId}")
    public com.totemcrew.teacherservice.teachers.resource.TeacherResource getTeacherById(@PathVariable("teacherId") Long teacherId) {
        return mapper.toResource(teacherService.getById(teacherId));
    }

    @PostMapping("")
    public com.totemcrew.teacherservice.teachers.resource.TeacherResource createUser(@RequestBody com.totemcrew.teacherservice.teachers.resource.CreateTeacherResource request) {
        return mapper.toResource(teacherService.create(mapper.toModel(request)));
    }

    @PutMapping("{teacherId}")
    public com.totemcrew.teacherservice.teachers.resource.TeacherResource updateTeacher(@PathVariable Long teacherId, @RequestBody com.totemcrew.teacherservice.teachers.resource.UpdateTeacherResource request) {
        return mapper.toResource(teacherService.update(teacherId, mapper.toModel(request)));
    }

    @DeleteMapping("{teacherId}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long teacherId) {
        return teacherService.delete(teacherId);
    }
}
