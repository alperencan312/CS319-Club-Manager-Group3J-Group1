package com.club1.studentclubmanager;

import com.club1.studentclubmanager.model.Student;
import com.club1.studentclubmanager.model.User;
import com.club1.studentclubmanager.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StudentClubManagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentClubManagerApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {

		// EXAMPLE OF ADDING STUDENT REPOSITORY
		// NOTE THAT ADDING STUDENT REPOSITORY ALSO CHANGES USER REPOSITORY.
		/*
		Student student = new Student();
		User user = new User(21505215L, "Ali Güneş", "ali.gunes@bilkent.edu.tr", "ali1234", "Bilkent University");

		student.setUser(user);

		this.studentRepository.save(student);
		 */

	}
}
