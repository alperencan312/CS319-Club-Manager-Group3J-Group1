package com.club1.studentclubmanager.repo;

import com.club1.studentclubmanager.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {
    void deleteSchoolById(Long id);

    Optional<School> findSchoolById(Long id);
}
