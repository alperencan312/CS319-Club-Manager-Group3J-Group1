package com.club1.studentclubmanager.service;

import com.club1.studentclubmanager.exception.CustomNotFoundException;
import com.club1.studentclubmanager.model.Student;
import com.club1.studentclubmanager.model.User;
import com.club1.studentclubmanager.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    
    private final StudentRepository studentRepository;

    private final ClubService clubService;

    @Autowired
    public StudentService(StudentRepository studentRepository, ClubService clubService) {
        this.studentRepository = studentRepository;
        this.clubService = clubService;
    }

    public Student addStudent(Student student){
        // Scenario of registration for now.
        // Since registration is not implemented in front-end for now, addStudent method will be used to add Students.
        // Passwords are stored in encrypted database.
        User user = student.getUser();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());

        user.setPassword(encodedPassword);
        student.setUser(user);

        return studentRepository.save(student);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student, Long id){
        // Check if the student exists
        Student existingStudent = studentRepository.findById(id).
                orElseThrow(() -> new CustomNotFoundException("Student by id "+ id + " was not found"));

        existingStudent.setSchool(student.getSchool());
        existingStudent.setUser(student.getUser());
        existingStudent.setClubs(student.getClubs());

        return studentRepository.save(existingStudent);
    }

    public Student findStudentById(Long id){
        return studentRepository.findById(id).
                orElseThrow(() -> new CustomNotFoundException("Student by id "+ id + " was not found"));
    }

    // Deletes the student by id.
    // If the student is leader or co-leader in any club, the properties in the club table are set to null.
    public void deleteStudentById(Long id){
        // Check if the student exists.
        boolean exists = studentRepository.existsById(id);
        if (!exists){
            throw new CustomNotFoundException("Student by id " + id + " was not found");
        }

        // Check if the student is the leader of some clubs.
        Student student = studentRepository.findById(id).get();
        List<Long> clubsLeaded = clubService.findClubsLeadedBy(student);
        System.out.println(clubsLeaded.size());

        // If the student is leader of some clubs, then set its leader property to null in every club
        if ( !clubsLeaded.isEmpty()){
            for (Long clubId : clubsLeaded)
                clubService.changeLeaderToNull(clubId);
        }

        // Check if the student is the co-leader of some clubs.
        List<Long> clubsCoLeaded = clubService.findClubCoLeadedBy(student);

        // If so, change club.coLeader value to null in every club.
        if ( !clubsCoLeaded.isEmpty()){
            for ( Long clubId: clubsLeaded)
                clubService.changeCoLeaderToNull(clubId);
        }

        studentRepository.deleteById(id);
    }
}
