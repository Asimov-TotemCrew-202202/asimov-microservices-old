package com.totemcrew.teacherservice.teachers.mapping;

//import com.totemcrew.teacherservice.announcements.resource.AnnouncementResource;
import com.totemcrew.teacherservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class TeacherMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public com.totemcrew.teacherservice.teachers.resource.TeacherResource toResource(com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher model) {
        return mapper.map(model, com.totemcrew.teacherservice.teachers.resource.TeacherResource.class);
    }

    public Page<com.totemcrew.teacherservice.teachers.resource.TeacherResource> modelListToPage(List<com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, com.totemcrew.teacherservice.teachers.resource.TeacherResource.class), pageable, modelList.size());
    }

    public List<com.totemcrew.teacherservice.teachers.resource.TeacherResource> modelListToResource(List<com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher> modelList){
        return mapper.mapList(modelList, com.totemcrew.teacherservice.teachers.resource.TeacherResource.class);
    }

    public com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher toModel(com.totemcrew.teacherservice.teachers.resource.CreateTeacherResource resource) {
        return mapper.map(resource, com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher.class);
    }

    public com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher toModel(com.totemcrew.teacherservice.teachers.resource.UpdateTeacherResource resource) {
        return mapper.map(resource, com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher.class);
    }
}
