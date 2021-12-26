package com.club1.studentclubmanager.controller;

import com.club1.studentclubmanager.model.Announcement;
import com.club1.studentclubmanager.service.AnnouncementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcements")
@CrossOrigin("*")
public class AnnouncementController {
    private AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping
    public ResponseEntity<List<Announcement>> getAllAnnouncements(){
        List<Announcement> announcements = announcementService.findAllAnnouncements();
        return new ResponseEntity<>(announcements, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Announcement> getAnnouncementById(@PathVariable("id") Long id){
        Announcement announcement = announcementService.findAnnouncementById(id);
        return new ResponseEntity<>(announcement, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Announcement> addAnnouncement(@RequestBody Announcement announcement){
        Announcement newAnnouncement = announcementService.addAnnouncement(announcement);
        return new ResponseEntity<>(newAnnouncement, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Announcement> updateAnnouncement(@PathVariable("id") Long id, @RequestBody Announcement announcement){
        Announcement updatedAnnouncement = announcementService.updateAnnouncement(announcement, id);
        return new ResponseEntity<>(updatedAnnouncement, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAnnouncement(@PathVariable("id") Long id){
        announcementService.deleteAnnouncementById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
