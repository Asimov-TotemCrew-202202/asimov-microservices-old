package com.totemcrew.competences.service;

import com.totemcrew.competences.events.CompetenceCreatedEvent;
import com.totemcrew.competences.events.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CompetenceEventsConsumerService {

    @KafkaListener(
            topics = "${topic.competence.name:competences}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "group1")
    public void consumer(Event<?> event) {
        if (event.getClass().isAssignableFrom(CompetenceCreatedEvent.class)) {
            CompetenceCreatedEvent customerCreatedEvent = (CompetenceCreatedEvent) event;
            log.info("Received Competence created event .... with Id={}, data={}",
                    customerCreatedEvent.getId(),
                    customerCreatedEvent.getData().toString());
        }

    }

}
