package com.club1.studentclubmanager.repo;

import com.club1.studentclubmanager.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    void deleteAnnouncementById(Long id);

    Optional<Announcement> findAnnouncementById(Long id);
}
