package com.club1.studentclubmanager.controller;


import com.club1.studentclubmanager.model.Club;
import com.club1.studentclubmanager.service.ClubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
@CrossOrigin("*")
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public ResponseEntity<List<Club>> getAllClubs(){
        List<Club> clubs = clubService.findAllClubs();
        return new ResponseEntity<>(clubs, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Club> getClubById(@PathVariable("id") Long id){
        Club club = clubService.findClubById(id);
        return new ResponseEntity<>(club, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Club> addClub(@RequestBody Club club){
        Club newClub = clubService.addClub(club);
        return new ResponseEntity<>(newClub, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Club> updateClub(@PathVariable("id") Long id, @RequestBody Club club){
        Club updatedClub = clubService.updateClub(club, id);
        return new ResponseEntity<>(updatedClub, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteClub(@PathVariable("id") Long id){
        clubService.deleteClubById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
