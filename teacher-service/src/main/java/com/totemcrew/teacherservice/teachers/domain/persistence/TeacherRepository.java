package com.totemcrew.teacherservice.teachers.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<com.totemcrew.teacherservice.teachers.domain.model.entity.Teacher, Long> {

    //@Query("select d from Teacher d where d.email = ?1")
    //Optional<teacher> findByEmail(String email);

    Boolean existsByEmail(String email);
}
