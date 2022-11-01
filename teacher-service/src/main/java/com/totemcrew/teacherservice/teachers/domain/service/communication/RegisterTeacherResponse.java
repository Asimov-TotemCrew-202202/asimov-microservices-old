package com.totemcrew.teacherservice.teachers.domain.service.communication;

import com.totemcrew.teacherservice.shared.domain.service.communication.BaseResponse;

public class RegisterTeacherResponse extends BaseResponse<com.totemcrew.teacherservice.teachers.resource.TeacherResource> {
    public RegisterTeacherResponse(String message) {
        super(message);
    }

    public RegisterTeacherResponse(com.totemcrew.teacherservice.teachers.resource.TeacherResource resource) {
        super(resource);
    }
}
