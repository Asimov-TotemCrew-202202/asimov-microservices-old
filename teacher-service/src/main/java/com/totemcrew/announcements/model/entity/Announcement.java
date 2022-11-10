package com.totemcrew.announcements.model.entity;

import com.totemcrew.shared.domain.model.AuditModel;
import lombok.Data;

@Data
public class Announcement extends AuditModel {

    private Long id;

    private String title;

    private String description;
}
