package com.club1.studentclubmanager.repo;

import com.club1.studentclubmanager.model.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    void deleteKeywordById(Long id);

    Optional<Keyword> findKeywordById(Long id);
}
