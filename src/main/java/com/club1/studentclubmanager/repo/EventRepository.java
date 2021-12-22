package com.club1.studentclubmanager.repo;

import com.club1.studentclubmanager.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    void deleteEventById(Long id);

    Optional<Event> findEventById(Long id);
}
