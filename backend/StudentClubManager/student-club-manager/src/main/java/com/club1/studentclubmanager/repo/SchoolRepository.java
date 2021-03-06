package com.club1.studentclubmanager.repo;

import com.club1.studentclubmanager.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {
    void deleteSchoolById(Long id);

    Optional<School> findSchoolById(Long id);

    @Query(value = "SELECT a FROM school a WHERE a.schoolName=?1")
    Optional<School> findSchoolByName(String schoolName);

    @Query(value = "SELECT a FROM school a WHERE a.logo=?1")
    Optional<School> findSchoolByLogo(String logo);

    //@Query(value = "SELECT a.schoolName, b.name FROM school a join club b ON b.school=a")
    @Query(value = "SELECT a.schoolName, a.logo FROM school a")
    List<School> findFront();
}
