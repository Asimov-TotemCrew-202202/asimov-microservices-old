package com.totemcrew.competences.model.entity;

import com.totemcrew.shared.domain.model.AuditModel;
import lombok.*;

@Data
public class Competence extends AuditModel {

    private Long id;

    private String title;

    private String description;

}
