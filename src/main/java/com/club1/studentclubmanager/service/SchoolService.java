package com.club1.studentclubmanager.service;

import com.club1.studentclubmanager.exception.UserNotFoundException;
import com.club1.studentclubmanager.model.School;
import com.club1.studentclubmanager.model.Student;
import com.club1.studentclubmanager.repo.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;
    }

    public List<School> findAllSchools(){
        return schoolRepository.findAll();
    }

    public School updateSchool(School school){
        return schoolRepository.save(school);
    }

    public School addSchool(School school){
        return schoolRepository.save(school);
    }

    public School findSchoolById(Long id){
        return schoolRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException("School by id "+ id + " was not found"));
    }
    public void deleteSchoolById(Long id){
        boolean exists = schoolRepository.existsById(id);
        if (!exists){
            throw new UserNotFoundException("School by id " + id + " was not found");
        }
        schoolRepository.deleteById(id);
    }
}
