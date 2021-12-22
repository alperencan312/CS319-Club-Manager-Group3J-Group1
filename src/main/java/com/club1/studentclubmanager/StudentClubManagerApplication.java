package com.club1.studentclubmanager;

import com.club1.studentclubmanager.model.*;
import com.club1.studentclubmanager.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.Instant;


@SpringBootApplication
public class StudentClubManagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentClubManagerApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SchoolRepository schoolRepository;

	@Autowired
	private ClubRepository clubRepository;

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private AnnouncementRepository announcementRepository;

	@Override
	public void run(String... args) throws Exception {

		// EXAMPLE OF ADDING STUDENT REPOSITORY
		// NOTE THAT ADDING STUDENT REPOSITORY ALSO CHANGES USER REPOSITORY.

/*
------------1------------------
		Student student = new Student();
		User user = new User(20204813L, "Yusuf sarı", "yusuf.sari@bilkent.edu.tr", "yusuf1234");
		School school = new School("Bilkent University", "Bilkent University logo");
		schoolRepository.save(school);
		student.setUser(user);
		student.setSchool(school);

		this.studentRepository.save(student);




		Club club = new Club("ACM", "This is a nice club.", "tech", "acm club logo", school, student, student);
		clubRepository.save(club);

		Timestamp timestamp = Timestamp.from(Instant.now());
		Event event = new Event("Java Tutorial Event", timestamp, "EE-01", "A tutorial will be given", club);

		eventRepository.save(event);



----------2---------------------
		Student student = new Student();
		User user = new User(20802671L, "ali kara", "ali.kara@bilkent.edu.tr", "ali1234");
		School school = new School("Ordu University", "Ordu University logo");
		schoolRepository.save(school);
		student.setUser(user);
		student.setSchool(school);

		this.studentRepository.save(student);
		Club club = new Club("YES", "This is a nice club.", "tech", "YES club logo", school, student, student);
		clubRepository.save(club);

		Timestamp timestamp = Timestamp.from(Instant.now());
		Announcement announcement = new Announcement("Mr. Tuzun will make a presentation today", timestamp, club);
		announcementRepository.save(announcement);
		*/

	}


}
