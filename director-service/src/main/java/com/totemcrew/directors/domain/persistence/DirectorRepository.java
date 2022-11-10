package com.totemcrew.directors.domain.persistence;

import com.totemcrew.directors.domain.model.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

    //@Query("select d from Director d where d.email = ?1")
    //Optional<Director> findByEmail(String email);

    Boolean existsByEmail(String email);
}
