package com.totemcrew.competenceservice.competences.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateCompetenceResource {

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String title;

    @NotNull
    @NotBlank
    private String description;
}
