package com.totemcrew.directorservice.directors.domain.service.communication;

import com.totemcrew.directorservice.directors.resource.DirectorResource;
import com.totemcrew.directorservice.shared.domain.service.communication.BaseResponse;

public class RegisterDirectorResponse extends BaseResponse<DirectorResource> {
    public RegisterDirectorResponse(String message) {
        super(message);
    }

    public RegisterDirectorResponse(DirectorResource resource) {
        super(resource);
    }
}
