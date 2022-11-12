package com.totemcrew.announcements.api;

import com.totemcrew.announcements.resource.AnnouncementResource;
import com.totemcrew.announcements.resource.CreateAnnouncementResource;
import com.totemcrew.announcements.resource.UpdateAnnouncementResource;
import com.totemcrew.announcements.domain.service.AnnouncementService;
import com.totemcrew.announcements.mapping.AnnouncementMapper;
import com.totemcrew.announcements.service.AnnouncementEventsProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AnnouncementsController {

    private final AnnouncementService announcementService;

    private final AnnouncementMapper mapper;
    private final AnnouncementEventsProducerService announcementEventsProducerService;

    public AnnouncementsController(AnnouncementService announcementService, AnnouncementMapper mapper, AnnouncementEventsProducerService announcementEventsProducerService) {
        this.announcementService = announcementService;
        this.mapper = mapper;
        this.announcementEventsProducerService = announcementEventsProducerService;
    }

    @GetMapping("directors/{directorId}/announcements")
    public List<AnnouncementResource> getAllAnnouncementsByDirectorId(@PathVariable Long directorId) {


        return mapper.modelListToResource(announcementService.getAllByDirectorId(directorId));
    }

    @PostMapping("directors/{directorId}/announcements")
    public AnnouncementResource createAnnouncement(@PathVariable Long directorId, @RequestBody CreateAnnouncementResource request) {
        var val = mapper.toResource(announcementService.create(directorId, mapper.toModel(request)));
        this.announcementEventsProducerService.publish(val);
        return val;
    }

    @PutMapping("announcements/{announcementId}")
    public AnnouncementResource updateAnnouncement(@PathVariable Long announcementId, @RequestBody UpdateAnnouncementResource request) {
        return mapper.toResource(announcementService.update(announcementId, mapper.toModel(request)));
    }

    @DeleteMapping("announcements/{announcementId}")
    public ResponseEntity<?> deleteAnnouncement(@PathVariable Long announcementId) {
        return announcementService.delete(announcementId);
    }
}