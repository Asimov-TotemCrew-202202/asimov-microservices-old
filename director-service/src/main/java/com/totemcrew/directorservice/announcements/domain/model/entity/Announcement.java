package com.totemcrew.directorservice.announcements.domain.model.entity;

import com.totemcrew.directorservice.directors.domain.model.entity.Director;
import com.totemcrew.directorservice.shared.domain.model.AuditModel;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "announcements")
public class Announcement extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 120)
    private String title;

    @NotNull
    @NotBlank
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;
}
