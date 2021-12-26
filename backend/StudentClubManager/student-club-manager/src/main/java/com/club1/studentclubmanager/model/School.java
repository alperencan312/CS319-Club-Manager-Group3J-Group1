package com.club1.studentclubmanager.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity(name="school")
@Table(name="school")
public class School {

    @Id
    @SequenceGenerator(
            name = "school_sequence",
            sequenceName = "school_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "school_sequence"
    )
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(nullable = false, unique = true)
    private String schoolName;

    @Column(nullable = false, unique = true)
    private String logo;

    @Column(nullable = false, unique = true)
    private String bgImage;

    @JsonIgnore
    @OneToMany(mappedBy = "school",targetEntity = Student.class, cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(mappedBy = "school",targetEntity = Club.class, cascade = CascadeType.ALL)
    private List<Club> clubs;

    public School() {
    }

    public School(String schoolName, String logo, String bgImage) {
        this.schoolName = schoolName;
        this.logo = logo;
        this.bgImage = bgImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("name")
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

    @JsonProperty("bg")
    public String getBgImage() {
        return bgImage;
    }

    public void setBgImage(String bgImage) {
        this.bgImage = bgImage;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

}
