package com.club1.studentclubmanager.service;

import com.club1.studentclubmanager.exception.UserNotFoundException;
import com.club1.studentclubmanager.model.Announcement;
import com.club1.studentclubmanager.repo.AnnouncementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {
    private AnnouncementRepository announcementRepository;

    public AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    public Announcement addAnnouncement(Announcement announcement){
        return announcementRepository.save(announcement);
    }

    public List<Announcement> findAllAnnouncements(){
        return announcementRepository.findAll();
    }

    public Announcement updateAnnouncement(Announcement announcement){
        return announcementRepository.save(announcement);
    }

    public Announcement findAnnouncementById(Long id){
        return announcementRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException("announcement by id "+ id + " was not found"));
    }
    public void deleteAnnouncementById(Long id){
        boolean exists = announcementRepository.existsById(id);
        if (!exists){
            throw new UserNotFoundException("announcement by id " + id + " was not found");
        }
        announcementRepository.deleteById(id);
    }
}
