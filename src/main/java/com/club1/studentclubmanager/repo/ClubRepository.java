package com.club1.studentclubmanager.repo;

import com.club1.studentclubmanager.model.Club;
import com.club1.studentclubmanager.model.School;
import com.club1.studentclubmanager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
    void deleteClubById(Long id);

    Optional<Club> findClubById(Long id);

    @Query(value = "SELECT a FROM club a WHERE a.name=?1 and a.school=?2")
    Optional<Club> findClubByNameInSameSchool(String clubName, School school);

    @Query(value = "SELECT a FROM club a WHERE a.clubLogo=?1 and a.school=?2")
    Optional<Club> findClubByLogoInSameSchool(String logo, School school);

    @Query(value = "SELECT a.id FROM club a WHERE a.clubLeader=?1")
    List<Long> findClubsWhereStudentIsLeader(Student student);

    @Query(value = "SELECT a.id FROM club a WHERE a.clubCoLeader=?1")
    List<Long> findClubsWhereStudentIsCoLeader(Student student);
}
