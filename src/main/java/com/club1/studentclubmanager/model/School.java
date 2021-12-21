package com.club1.studentclubmanager.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="school")
public class School {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(nullable = false, unique = true)
    private String schoolName;

    @Column(nullable = false, unique = true)
    private String logo;

    @OneToMany(mappedBy = "school",targetEntity = Student.class, cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(mappedBy = "school",targetEntity = Club.class, cascade = CascadeType.ALL)
    private List<Club> clubs;

    public School() {
    }

    public School(String schoolName, String logo) {
        this.schoolName = schoolName;
        this.logo = logo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
