package com.totemcrew.competences.service;

import com.totemcrew.competences.domain.model.entity.Competence;
import com.totemcrew.competences.events.Event;
import com.totemcrew.competences.events.EventType;
import com.totemcrew.competences.events.CompetenceCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class CompetenceEventsProducerService {
    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.competence.name:competences}")
    private String topicCompetence;

    public void publish(Competence competence) {

        CompetenceCreatedEvent created = new CompetenceCreatedEvent();
        created.setData(competence);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicCompetence, created);
    }
}
