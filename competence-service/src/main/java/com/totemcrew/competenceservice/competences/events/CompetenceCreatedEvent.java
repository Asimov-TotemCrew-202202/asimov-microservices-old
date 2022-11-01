package com.totemcrew.competenceservice.competences.events;

import com.totemcrew.competenceservice.competences.domain.model.entity.Competence;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompetenceCreatedEvent extends Event<Competence> {
}
