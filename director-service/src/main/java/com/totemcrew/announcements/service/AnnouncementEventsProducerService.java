package com.totemcrew.announcements.service;

import com.totemcrew.announcements.domain.model.entity.Announcement;
import com.totemcrew.announcements.events.AnnouncementCreatedEvent;
import com.totemcrew.announcements.events.Event;
import com.totemcrew.announcements.events.EventType;
import com.totemcrew.announcements.resource.AnnouncementResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class AnnouncementEventsProducerService {
    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.announcement.name:announcements}")
    private String topicAnnouncement;

    public void publish(AnnouncementResource announcement) {

        AnnouncementCreatedEvent created = new AnnouncementCreatedEvent();
        created.setData(announcement);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicAnnouncement, created);
    }
}
