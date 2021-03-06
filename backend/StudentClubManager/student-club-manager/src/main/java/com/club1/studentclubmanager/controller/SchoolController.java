package com.club1.studentclubmanager.controller;

import com.club1.studentclubmanager.model.School;
import com.club1.studentclubmanager.model.Student;
import com.club1.studentclubmanager.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
@CrossOrigin(origins = "*")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools(){
        List<School> schools = schoolService.findAllSchools();
        return new ResponseEntity<>(schools, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<School>> getAllForFrontEnd(){
        List<School> schools = schoolService.findAllForFrontEnd();
        return new ResponseEntity<>(schools, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable("id") Long id){
        School school = schoolService.findSchoolById(id);
        return new ResponseEntity<>(school, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<School> addSchool(@RequestBody School school){
        School newSchool = schoolService.addSchool(school);
        return new ResponseEntity<>(newSchool, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<School> updateSchool(@PathVariable("id") Long id, @RequestBody School school){
        School updatedSchool = schoolService.updateSchool(school, id);
        return new ResponseEntity<>(updatedSchool, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteSchool(@PathVariable("id") Long id){
        schoolService.deleteSchoolById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
