package com.totemcrew.announcements.service;

import com.totemcrew.announcements.domain.model.entity.Announcement;
import com.totemcrew.announcements.domain.persistence.AnnouncementRepository;
import com.totemcrew.announcements.domain.service.AnnouncementService;
import com.totemcrew.directors.domain.persistence.DirectorRepository;
import com.totemcrew.shared.exception.ResourceNotFoundException;
import com.totemcrew.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private static final String ENTITY = "Announcement";

    private final AnnouncementRepository announcementRepository;

    private final DirectorRepository directorRepository;

    private final Validator validator;

    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository, DirectorRepository directorRepository, Validator validator) {
        super();
        this.announcementRepository = announcementRepository;
        this.directorRepository = directorRepository;
        this.validator = validator;
    }

    @Override
    public List<Announcement> getAllByDirectorId(Long directorId) {
        var existingDirector = directorRepository.findById(directorId);

        if(existingDirector.isEmpty())
            throw new ResourceNotFoundException("Director", directorId);

        return announcementRepository.findByDirectorId(directorId);
    }

    @Override
    public Page<Announcement> getAllByDirectorId(Long directorId, Pageable pageable) {
        return announcementRepository.findByDirectorId(directorId, pageable);
    }

    @Override
    public Announcement create(Long directorId, Announcement request) {
        Set<ConstraintViolation<Announcement>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return directorRepository.findById(directorId).map(director -> {
            request.setDirector(director);
            return announcementRepository.save(request);
        }).orElseThrow(() -> new ResourceNotFoundException("Director", directorId));
    }

    @Override
    public Announcement update(Long announcementId, Announcement request) {
        Set<ConstraintViolation<Announcement>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return announcementRepository.findById(announcementId).map(announcement ->
                announcementRepository.save(
                        announcement.withTitle(request.getTitle())
                                .withDescription(request.getDescription()))
                ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, announcementId));
    }

    @Override
    public ResponseEntity<?> delete(Long announcementId) {
        return announcementRepository.findById(announcementId).map(announcement -> {
                announcementRepository.delete(announcement);
                return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, announcementId));
    }
}
