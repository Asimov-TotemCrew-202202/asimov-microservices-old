package com.totemcrew.directors.mapping;

import com.totemcrew.directors.domain.model.entity.Director;
import com.totemcrew.directors.resource.CreateDirectorResource;
import com.totemcrew.directors.resource.DirectorResource;
import com.totemcrew.directors.resource.UpdateDirectorResource;
import com.totemcrew.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class DirectorMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public DirectorResource toResource(Director model) {
        return mapper.map(model, DirectorResource.class);
    }

    public Page<DirectorResource> modelListToPage(List<Director> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, DirectorResource.class), pageable, modelList.size());
    }

    public List<DirectorResource> modelListToResource(List<Director> modelList){
        return mapper.mapList(modelList, DirectorResource.class);
    }

    public Director toModel(CreateDirectorResource resource) {
        return mapper.map(resource, Director.class);
    }

    public Director toModel(UpdateDirectorResource resource) {
        return mapper.map(resource, Director.class);
    }
}
