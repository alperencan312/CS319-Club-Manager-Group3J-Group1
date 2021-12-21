package com.club1.studentclubmanager.repo;

import com.club1.studentclubmanager.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
    void deleteClubById(Long id);

    Optional<Club> findClubById(Long id);
}
