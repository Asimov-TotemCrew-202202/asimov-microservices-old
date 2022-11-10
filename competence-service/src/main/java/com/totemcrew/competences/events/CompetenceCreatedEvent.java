package com.totemcrew.competences.events;

import com.totemcrew.competences.domain.model.entity.Competence;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompetenceCreatedEvent extends Event<Competence> {
}
