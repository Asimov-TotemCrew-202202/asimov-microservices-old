package com.totemcrew.teachers.domain.persistence;

import com.totemcrew.teachers.domain.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    //@Query("select d from Teacher d where d.email = ?1")
    //Optional<teacher> findByEmail(String email);

    Boolean existsByEmail(String email);
}
