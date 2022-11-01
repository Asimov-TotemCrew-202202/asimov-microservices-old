package com.totemcrew.directorservice.announcements.api;

import com.totemcrew.directorservice.announcements.domain.service.AnnouncementService;
import com.totemcrew.directorservice.announcements.mapping.AnnouncementMapper;
import com.totemcrew.directorservice.announcements.resource.AnnouncementResource;
import com.totemcrew.directorservice.announcements.resource.CreateAnnouncementResource;
import com.totemcrew.directorservice.announcements.resource.UpdateAnnouncementResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AnnouncementsController {

    private final AnnouncementService announcementService;

    private final AnnouncementMapper mapper;

    public AnnouncementsController(AnnouncementService announcementService, AnnouncementMapper mapper) {
        this.announcementService = announcementService;
        this.mapper = mapper;
    }

    @GetMapping("directors/{directorId}/announcements")
    public List<AnnouncementResource> getAllAnnouncementsByDirectorId(@PathVariable Long directorId) {


        return mapper.modelListToResource(announcementService.getAllByDirectorId(directorId));
    }

    @PostMapping("directors/{directorId}/announcements")
    public AnnouncementResource createAnnouncement(@PathVariable Long directorId, @RequestBody CreateAnnouncementResource request) {
        return mapper.toResource(announcementService.create(directorId, mapper.toModel(request)));
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
