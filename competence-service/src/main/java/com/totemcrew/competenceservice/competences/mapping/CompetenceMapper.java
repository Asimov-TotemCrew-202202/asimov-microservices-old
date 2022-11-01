package com.totemcrew.competenceservice.competences.mapping;

import com.totemcrew.competenceservice.competences.domain.model.entity.Competence;
import com.totemcrew.competenceservice.competences.resource.CompetenceResource;
import com.totemcrew.competenceservice.competences.resource.CreateCompetenceResource;
import com.totemcrew.competenceservice.competences.resource.UpdateCompetenceResource;
import com.totemcrew.competenceservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class CompetenceMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public CompetenceResource toResource(Competence model) {
        return mapper.map(model, CompetenceResource.class);
    }

    public Page<CompetenceResource> modelListToPage(List<Competence> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, CompetenceResource.class), pageable, modelList.size());
    }

    public List<CompetenceResource> modelListToResource(List<Competence> modelList) {
        return mapper.mapList(modelList, CompetenceResource.class);
    }

    public Competence toModel(CreateCompetenceResource resource) {
        return mapper.map(resource, Competence.class);
    }

    public Competence toModel(UpdateCompetenceResource resource) {
        return mapper.map(resource, Competence.class);
    }
}
