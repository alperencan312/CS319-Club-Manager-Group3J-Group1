package com.club1.studentclubmanager.repo;

import com.club1.studentclubmanager.model.Student;
import com.club1.studentclubmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    void deleteStudentById(Long id);

    Optional<Student> findStudentById(Long id);
}
