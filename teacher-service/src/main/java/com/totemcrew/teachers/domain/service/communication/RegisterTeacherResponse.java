package com.totemcrew.teachers.domain.service.communication;

import com.totemcrew.shared.domain.service.communication.BaseResponse;
import com.totemcrew.teachers.resource.TeacherResource;

public class RegisterTeacherResponse extends BaseResponse<TeacherResource> {
    public RegisterTeacherResponse(String message) {
        super(message);
    }

    public RegisterTeacherResponse(TeacherResource resource) {
        super(resource);
    }
}
