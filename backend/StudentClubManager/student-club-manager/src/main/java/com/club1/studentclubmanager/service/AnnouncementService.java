package com.club1.studentclubmanager.service;

import com.club1.studentclubmanager.exception.CustomNotFoundException;
import com.club1.studentclubmanager.model.Announcement;
import com.club1.studentclubmanager.model.Club;
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

    public Announcement updateAnnouncement(Announcement announcement, Long id){
        // Check if the announcement exists
        Announcement existingAnnouncement = announcementRepository.findById(id).
                orElseThrow(() -> new CustomNotFoundException("Announcement by id "+ id + " was not found"));

        existingAnnouncement.setAnnouncementInfo(announcement.getAnnouncementInfo());
        existingAnnouncement.setClub(announcement.getClub());
        existingAnnouncement.setCreated_at(announcement.getCreated_at());

        return announcementRepository.save(existingAnnouncement);
    }

    public Announcement findAnnouncementById(Long id){
        return announcementRepository.findById(id).
                orElseThrow(() -> new CustomNotFoundException("announcement by id "+ id + " was not found"));
    }
    public void deleteAnnouncementById(Long id){
        boolean exists = announcementRepository.existsById(id);
        if (!exists){
            throw new CustomNotFoundException("announcement by id " + id + " was not found");
        }
        announcementRepository.deleteById(id);
    }
}
