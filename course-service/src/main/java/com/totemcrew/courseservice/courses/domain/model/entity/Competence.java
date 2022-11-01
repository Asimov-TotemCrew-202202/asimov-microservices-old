package com.totemcrew.courseservice.courses.domain.model.entity;

import com.totemcrew.courseservice.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
//@Data
public class Competence extends AuditModel {

    private Long id;

    private String title;

    private String description;

}
