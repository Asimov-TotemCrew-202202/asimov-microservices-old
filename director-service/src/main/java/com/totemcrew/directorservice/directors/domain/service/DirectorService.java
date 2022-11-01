package com.totemcrew.directorservice.directors.domain.service;

import com.totemcrew.directorservice.directors.domain.model.entity.Director;
import com.totemcrew.directorservice.directors.domain.service.communication.RegisterDirectorRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DirectorService{
    List<Director> getAll();
    Page<Director> getAll(Pageable pageable);
    Director getById(Long directorId);
    Director create(Director director);
    Director update(Long directorId, Director director);
    ResponseEntity<?> delete(Long directorId);
}
