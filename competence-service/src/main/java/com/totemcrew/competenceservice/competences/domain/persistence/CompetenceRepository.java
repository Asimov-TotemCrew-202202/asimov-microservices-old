package com.totemcrew.competenceservice.competences.domain.persistence;

import com.totemcrew.competenceservice.competences.domain.model.entity.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {

}
