package com.club1.studentclubmanager.service;


import com.club1.studentclubmanager.exception.UserNotFoundException;
import com.club1.studentclubmanager.model.Club;
import com.club1.studentclubmanager.repo.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public Club addClub(Club club){
        return clubRepository.save(club);
    }

    public List<Club> findAllClubs(){
        return clubRepository.findAll();
    }

    public Club updateClub(Club club){
        return clubRepository.save(club);
    }

    public Club findClubById(Long id){
        return clubRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException("club by id "+ id + " was not found"));
    }
    public void deleteClubById(Long id){
        boolean exists = clubRepository.existsById(id);
        if (!exists){
            throw new UserNotFoundException("club by id " + id + " was not found");
        }
        clubRepository.deleteById(id);
    }
}
