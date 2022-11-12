package com.totemcrew.announcements.service;

import com.totemcrew.announcements.events.AnnouncementCreatedEvent;
import com.totemcrew.announcements.events.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnnouncementEventsConsumerService {

    @KafkaListener(
            topics = "${topic.announcement.name:announcements}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "group2")
    public void consumer(Event<?> event) {
        if (event.getClass().isAssignableFrom(AnnouncementCreatedEvent.class)) {
            AnnouncementCreatedEvent customerCreatedEvent = (AnnouncementCreatedEvent) event;
            log.info("Received Announcement created event .... with Id={}, data={}",
                    customerCreatedEvent.getId(),
                    customerCreatedEvent.getData().toString());
        }

    }
}
