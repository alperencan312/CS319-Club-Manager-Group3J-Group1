package com.club1.studentclubmanager.service;

import com.club1.studentclubmanager.exception.UserNotFoundException;
import com.club1.studentclubmanager.model.Student;
import com.club1.studentclubmanager.model.Student;
import com.club1.studentclubmanager.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student updateStudent(Student Student){
        return studentRepository.save(Student);
    }

    public Student findStudentById(Long id){
        return studentRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException("Student by id "+ id + " was not found"));
    }
    public void deleteStudentById(Long id){
        boolean exists = studentRepository.existsById(id);
        if (!exists){
            throw new UserNotFoundException("Student by id " + id + " was not found");
        }
        studentRepository.deleteById(id);
    }
}
