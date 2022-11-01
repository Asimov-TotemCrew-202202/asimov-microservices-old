package com.totemcrew.courseservice.courses.events;

import com.totemcrew.courseservice.courses.domain.model.entity.Competence;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompetenceCreatedEvent extends Event<Competence> {
}
