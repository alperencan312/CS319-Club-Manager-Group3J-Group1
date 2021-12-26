package com.club1.studentclubmanager.repo;

import com.club1.studentclubmanager.model.Club;
import com.club1.studentclubmanager.model.Student;
import com.club1.studentclubmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    void deleteStudentById(Long id);

    Optional<Student> findStudentById(Long id);

    @Query(value = "SELECT a FROM club a WHERE a.clubCoLeader=?1 LIMIT 1", nativeQuery = true)
    void makeLeaderNull(Student student);
}
