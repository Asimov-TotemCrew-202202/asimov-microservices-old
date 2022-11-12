package com.totemcrew.announcements.events;

import com.totemcrew.announcements.resource.AnnouncementResource;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AnnouncementCreatedEvent extends Event<AnnouncementResource> {
}
