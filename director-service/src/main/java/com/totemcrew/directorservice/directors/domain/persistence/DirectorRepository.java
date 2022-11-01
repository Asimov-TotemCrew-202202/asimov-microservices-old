package com.totemcrew.directorservice.directors.domain.persistence;

import com.totemcrew.directorservice.directors.domain.model.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

    //@Query("select d from Director d where d.email = ?1")
    //Optional<Director> findByEmail(String email);

    Boolean existsByEmail(String email);
}
