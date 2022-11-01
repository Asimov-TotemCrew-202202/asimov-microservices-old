package com.totemcrew.competenceservice.competences.service;

import com.totemcrew.competenceservice.competences.domain.model.entity.Competence;
import com.totemcrew.competenceservice.competences.events.CompetenceCreatedEvent;
import com.totemcrew.competenceservice.competences.events.Event;
import com.totemcrew.competenceservice.competences.events.EventType;
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
