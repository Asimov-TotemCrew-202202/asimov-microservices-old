package com.totemcrew.items.domain.persistence;

import com.totemcrew.items.domain.model.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCourseId(long courseId);
    Page<Item> findByCourseId(long courseId, Pageable pageable);
}
