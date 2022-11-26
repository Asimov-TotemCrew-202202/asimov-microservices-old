package com.totemcrew.courses.domain.persistence;

import com.totemcrew.courses.domain.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select d from Course d where d.name = ?1")
    Course findByName(String name);
}
