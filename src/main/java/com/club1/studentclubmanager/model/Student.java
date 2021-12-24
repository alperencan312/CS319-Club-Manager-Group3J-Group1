package com.club1.studentclubmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long id; // this is only to keep record of students in database.


    // NOTE THAT ADDING STUDENT TO STUDENT TABLE WILL CREATE A USER IN USER TABLE
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "membership", joinColumns = { @JoinColumn(name="student_id")},
        inverseJoinColumns = {@JoinColumn(name="club_id")})
    private List<Club> clubs;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Student(){

    }

    public Student(User user, School school) {
        this.user = user;
        this.school = school;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id) && Objects.equals(user, student.user) && school.equals(student.school) && Objects.equals(clubs, student.clubs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, school, clubs);
    }
}
