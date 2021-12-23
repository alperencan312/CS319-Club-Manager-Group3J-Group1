package com.club1.studentclubmanager.service;


import com.club1.studentclubmanager.exception.CustomNotFoundException;
import com.club1.studentclubmanager.model.Club;
import com.club1.studentclubmanager.model.School;
import com.club1.studentclubmanager.model.Student;
import com.club1.studentclubmanager.repo.ClubRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    // Add club to the database
    public Club addClub(Club club){
        // Club leader or co-leader cannot be from another school.
        if ( !isClubEligible(club))
            return null;

        School school = club.getSchool();

        // Check if the club name exists in same school.
        Optional<Club> c = clubRepository.findClubByNameInSameSchool(club.getName(), school);

        if ( c.isPresent()){
            // ERROR
            System.out.println("Error, Club name in " + school.getSchoolName() + " already exists!");
            return null;
        }

        // Check if the club logo exists in same school.
        c = clubRepository.findClubByLogoInSameSchool(club.getClubLogo(), school);
        if ( c.isPresent()){
            // ERROR
            System.out.println("Error, Club logo in " + school.getSchoolName() + " already exists!");
            return null;
        }


        // if the name and logo is not present in the school, add the club to the database.
        return clubRepository.save(club);
    }

    public List<Club> findAllClubs(){
        return clubRepository.findAll();
    }

    // updates the club
    public Club updateClub(Club club, Long id){
        // Check if the club exists by id.
        Club existingClub = clubRepository.findById(id).
                orElseThrow(() -> new CustomNotFoundException("Club by id "+ id + " was not found"));

        if ( !isClubEligible(club))
            return null;

        School school = club.getSchool();
        // Check that the name of the club is not the same with any other club in the same school.
        Optional<Club> c = clubRepository.findClubByNameInSameSchool(club.getName(), school);
        if ( c.isPresent() && (c.get() != existingClub)){
            System.out.println("Error, Club name already exists!");
            return null; // without updating the database
        }

        c = clubRepository.findClubByLogoInSameSchool(club.getClubLogo(), school);
        if ( c.isPresent() && (c.get() != existingClub)){
            System.out.println("Error, Club logo already exists!");
            return null;
        }

        existingClub.setName(club.getName());
        existingClub.setType(club.getType());
        existingClub.setInfo(club.getInfo());
        existingClub.setSchool(club.getSchool());
        existingClub.setClubLogo(club.getClubLogo());
        existingClub.setClubLeader(club.getClubLeader());
        existingClub.setClubCoLeader(club.getClubCoLeader());

        return clubRepository.save(existingClub);
    }

    public Club findClubById(Long id){
        return clubRepository.findById(id).
                orElseThrow(() -> new CustomNotFoundException("club by id "+ id + " was not found"));
    }

    public void deleteClubById(Long id){
        boolean exists = clubRepository.existsById(id);
        if (!exists){
            throw new CustomNotFoundException("club by id " + id + " was not found");
        }
        clubRepository.deleteById(id);
    }

    // Returns the Club if the student is the leader of a club, else null
    public List<Long> findClubsLeadedBy(Student student){
        return clubRepository.findClubsWhereStudentIsLeader(student);
    }

    // Returns the Club if the student is the co-leader of a club, else null
    public List<Long> findClubCoLeadedBy(Student student){
        return clubRepository.findClubsWhereStudentIsCoLeader(student);
    }

    public void changeLeaderToNull(Long clubId){
        Club club = clubRepository.findClubById(clubId).get();
        club.setClubLeader(null);
        updateClub(club, clubId);
    }

    public void changeCoLeaderToNull(Long clubId){
        Club club = clubRepository.findClubById(clubId).get();
        club.setClubCoLeader(null);
        updateClub(club, clubId);
    }

    // Returns ture if club leader and co-leader are from the same school with the club's school.
    public boolean isClubEligible(Club club){
        // Club leader cannot be from another school
        if ( club.getClubLeader().getSchool() != club.getSchool()){
            System.out.println("Error, Club leader cannot be from another school!");
            return false;
        }

        // Club co-leader cannot be from another school
        if (club.getClubCoLeader().getSchool() != club.getSchool()){
            System.out.println("Error, Club co-leader cannot be from another school!");
            return false;
        }
        return true;
    }

}
