package com.club1.studentclubmanager.service;

import com.club1.studentclubmanager.exception.CustomNotFoundException;
import com.club1.studentclubmanager.model.School;
import com.club1.studentclubmanager.repo.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;
    }

    public List<School> findAllSchools(){
        return schoolRepository.findAll();
    }

    public List<School> findAllForFrontEnd(){
        return schoolRepository.findFront();
    }

    // School name and logo must be unique to be added to the database.
    public School addSchool(School school){
        // Check if the school.getName() exists in database, if exists, don't add it to the database
        Optional<School> s = schoolRepository.findSchoolByName(school.getSchoolName());
        if ( s.isPresent()) {
            // ERROR
            System.out.println("Error, school name already exists");
            return null; // without adding it to the database
        }

        // Check if the school.getLogo() exists in database, if exists, don't add it to the database
        s = schoolRepository.findSchoolByLogo(school.getLogo());
        if ( s.isPresent()) {
            // ERROR
            System.out.println("Error, school logo already exists!");
            return null; // without adding it to the database
        }

        // If name and logo are unique, then add school to the database
        return schoolRepository.save(school);
    }

    // Corner cases are checked.
    // Check if the school exists
    // Check if the school to be updated is not the same of other schools considering name and logo.
    public School updateSchool(School school, Long id){
        // Check if the school exists
        School existingSchool = schoolRepository.findById(id).
                orElseThrow(() -> new CustomNotFoundException("School by id "+ id + " was not found"));

        // Check if the school.getName() exists in database, if exists, don't add it to the database
        Optional<School> s = schoolRepository.findSchoolByName(school.getSchoolName());
        if ( s.isPresent() && (s.get() != existingSchool)) {
            System.out.println("Error, school name already exists");
            return null; // without updating the database
        }

        // Check if the school.getLogo() exists in database, if exists, don't add it to the database
        s = schoolRepository.findSchoolByLogo(school.getLogo());
        if ( s.isPresent() && (s.get() != existingSchool)) {
            System.out.println("Error, school logo already exists!");
            return null; // without updating the database
        }

        existingSchool.setSchoolName(school.getSchoolName());
        existingSchool.setLogo(school.getLogo());
        existingSchool.setBgImage(school.getBgImage());
        return schoolRepository.save(existingSchool);
    }

    public School findSchoolById(Long id){
        return schoolRepository.findById(id).
                orElseThrow(() -> new CustomNotFoundException("School by id "+ id + " was not found"));
    }

    public void deleteSchoolById(Long id){
        boolean exists = schoolRepository.existsById(id);
        if (!exists){
            throw new CustomNotFoundException("School by id " + id + " was not found");
        }
        schoolRepository.deleteById(id);
    }
}
