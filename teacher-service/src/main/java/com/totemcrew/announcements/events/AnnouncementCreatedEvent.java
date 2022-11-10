package com.totemcrew.announcements.events;

import com.totemcrew.announcements.model.entity.Announcement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AnnouncementCreatedEvent extends Event<Announcement> {
}
