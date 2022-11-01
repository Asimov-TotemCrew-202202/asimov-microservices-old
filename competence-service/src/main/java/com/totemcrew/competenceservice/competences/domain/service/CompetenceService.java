package com.totemcrew.competenceservice.competences.domain.service;

import com.totemcrew.competenceservice.competences.domain.model.entity.Competence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompetenceService {
    List<Competence> getAll();
    Page<Competence> getAll(Pageable pageable);
    Competence getById(Long competenceId);
    Competence create(Competence competence);
    Competence update(Long competenceId, Competence request);
    ResponseEntity<?> delete(Long competenceId);
}
