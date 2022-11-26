package com.totemcrew.directors.domain.service.communication;

import com.totemcrew.directors.resource.DirectorResource;
import com.totemcrew.shared.domain.service.communication.BaseResponse;

public class RegisterDirectorResponse extends BaseResponse<DirectorResource> {
    public RegisterDirectorResponse(String message) {
        super(message);
    }

    public RegisterDirectorResponse(DirectorResource resource) {
        super(resource);
    }
}
