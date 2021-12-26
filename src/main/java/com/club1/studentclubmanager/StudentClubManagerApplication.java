package com.club1.studentclubmanager;

import com.club1.studentclubmanager.model.*;
import com.club1.studentclubmanager.repo.*;
import com.club1.studentclubmanager.service.ClubService;
import com.club1.studentclubmanager.service.SchoolService;
import com.club1.studentclubmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;


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

	@Autowired
	private SchoolService schoolService;

	@Autowired
	private ClubService clubService;

	@Autowired
	private StudentService studentService;

	@Override
	public void run(String... args) throws Exception {

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


		--------------3----------------------------

		School school = schoolService.findSchoolById(9L);
		//schoolService.addSchool(school);
		System.out.println(school.getSchoolName());

		Student student = new Student();
		User user = new User(20991659L, "mehmet can", "mehmet.can@bilkent.edu.tr", "mehmet1234");
		student.setUser(user);
		student.setSchool(school);

		this.studentRepository.save(student);
		Club club = new Club("YES", "This is a nice clubss.", "techss", "YESssss club logo", school, student, student);
		clubService.addClub(club);



		Student student = studentService.findStudentById(8L);
		School school = schoolService.findSchoolById(4L);
		Club club = new Club("hey", "Nice", "techhh", "hiii club logo", school, student, student);
		//clubService.addClub(club);
		//studentService.deleteStudentById(10L);
		//clubService.updateClub(club, 3L);


		Student student = studentService.findStudentById(8L);
		Club club = clubService.findClubById(7L);
		club.getStudents().add(student);
		System.out.println(club.getStudents());
		student.getClubs().add(club);
		studentService.updateStudent(student, 8L);


		Student student = new Student();
		User user = new User(21199522L, "eray tüzün", "eray.tüzün@bilkent.edu.tr", "eray1234");
		School school = schoolService.findSchoolById(4L);
		student.setUser(user);
		student.setSchool(school);

		this.studentService.addStudent(student);




		Student student = new Student();
		User user = new User(20802671L, "ali kara", "ali.kara@bilkent.edu.tr", "ali1234");
		School school = new School("Ordu University", "Ordu University logo", "bg img");
		schoolRepository.save(school);
		student.setUser(user);
		student.setSchool(school);

		this.studentRepository.save(student);
		Club club1 = new Club("YES", "This is a nice club.", "tech", "YES club logo", school, student, student);
		Club club2 = new Club("ACM", "Nice one.", "technology", "ACM club logo", school, student, student);
		clubRepository.save(club1);
		clubRepository.save(club2);


		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		Student student4 = new Student();
		User user1 = new User(20803571L, "mehmet kara", "mehmet@bilkent.edu.tr", "mehmet1234");
		User user2 = new User(20803566L, "ali şenol", "ali.senol@bilkent.edu.tr", "ali1234");
		User user3 = new User(20203500L, "cem yalçın", "cem.yalcin@itu.edu.tr", "cem1234");
		User user4 = new User(20103544L, "gamze akar", "gamze.akar@itu.edu.tr", "gamze1234");
		School school1 = new School("Bilkent University", "https://w3.bilkent.edu.tr/logo/ing-amblem.png", "https://www.remzihoca.com/storage/contents/1600171821-757171.jpg");
		School school2 = new School("Istanbul Technical University", "https://upload.wikimedia.org/wikipedia/en/thumb/c/c6/Istanbul_Technical_University_emblem.svg/1200px-Istanbul_Technical_University_emblem.svg.png", "https://www.remzihoca.com/storage/contents/1600952265-962331.jpg");
		schoolRepository.save(school1);
		schoolRepository.save(school2);
		student1.setUser(user1);
		student2.setUser(user2);
		student3.setUser(user3);
		student4.setUser(user4);
		student1.setProfileImg("https://img.freepik.com/free-photo/pleasant-looking-serious-man-stands-profile-has-confident-expression-wears-casual-white-t-shirt_273609-16959.jpg?size=626&ext=jpg");
		student1.setSchool(school1);
		student2.setProfileImg("https://i.pinimg.com/550x/79/42/24/794224be7ac8235184c1f69c66554075.jpg");
		student2.setSchool(school2);
		student3.setProfileImg("https://hthayat.haberturk.com/im/2017/10/26/1055643_95eb3d9cceb34b1d68072fe3e4d0fa56_600x600.jpg");
		student3.setSchool(school1);
		student4.setSchool(school2);
		student4.setProfileImg("https://www.wpdurum.com/uploads/thumbs/anime-kiz-profil-resimleri-1.jpg");

		this.studentService.addStudent(student1);
		this.studentService.addStudent(student2);
		this.studentService.addStudent(student3);
		this.studentService.addStudent(student4);

		Club club1 = new Club("MT Bilkent", "MT Bilkent is a nice club!", "Club", "https://pbs.twimg.com/profile_images/480050296702259200/mag5F_xR_400x400.png",
				school1, student1, student3);


		Club club2 = new Club("ITU English Speaking Club", "ITU English Speaking Club is a nice club!", "Club", "https://mir-s3-cdn-cf.behance.net/project_modules/fs/85b79097876423.5ed46890ad61a.png",school2, student2, student4);

		clubRepository.save(club1);
		clubRepository.save(club2);

		Announcement announcement1 = new Announcement("Mr Tuzun will make a presentation.", Timestamp.from(Instant.now()), club1);
		Announcement announcement2 = new Announcement("Last Eight tickets for the next week's activity.", Timestamp.from(Instant.now()), club1);
		Announcement announcement3 = new Announcement("We will meet at Med-236 tomorrow, 18.30.", Timestamp.from(Instant.now()), club2);

		announcementRepository.save(announcement1);
		announcementRepository.save(announcement2);
		announcementRepository.save(announcement3);

		Event event1 = new Event("Gaming Event", new Timestamp(new Date().getTime()), "G-210", "Championship starts. Get ready everyone!",
				club1, "2 hrs");

		eventRepository.save(event1);
		*/
	}


}
