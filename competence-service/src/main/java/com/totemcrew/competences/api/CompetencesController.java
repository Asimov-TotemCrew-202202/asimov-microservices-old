package com.totemcrew.competences.api;

import com.totemcrew.competences.domain.service.CompetenceService;
import com.totemcrew.competences.mapping.CompetenceMapper;
import com.totemcrew.competences.resource.CompetenceResource;
import com.totemcrew.competences.resource.CreateCompetenceResource;
import com.totemcrew.competences.resource.UpdateCompetenceResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CompetencesController {

    @Autowired
    private CompetenceService competenceService;

    @Autowired
    private CompetenceMapper mapper;

    @GetMapping("competences")
    public List<CompetenceResource> getAllCompetences() {
        return mapper.modelListToResource(competenceService.getAll());
    }

    @GetMapping("competences/{competenceId}")
    public CompetenceResource getCompetenceById(@PathVariable("competenceId") Long competenceId) {
        return mapper.toResource(competenceService.getById(competenceId));
    }

    @PostMapping("competences")
    public CompetenceResource createCompetence(@RequestBody CreateCompetenceResource request) {

        return mapper.toResource(competenceService.create(mapper.toModel(request)));
    }

    @PutMapping("competences/{competenceId}")
    public CompetenceResource updateCompetence(@PathVariable Long competenceId, @RequestBody UpdateCompetenceResource request) {
        return mapper.toResource(competenceService.update(competenceId, mapper.toModel(request)));
    }

    @DeleteMapping("competences/{competenceId}")
    public ResponseEntity<?> deleteCompetence(@PathVariable Long competenceId) {
        return competenceService.delete(competenceId);
    }

}
