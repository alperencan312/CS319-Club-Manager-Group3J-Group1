package com.club1.studentclubmanager.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "club")
@Table(name= "club")
public class Club {

    /**
     * Add leader, add co-leader düzenle.
     * Bunlar eklendiğinde member olup olmadığına bak.
     */
    @Id
    @SequenceGenerator(
            name = "club_sequence",
            sequenceName = "club_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "club_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String info;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false, unique = true)
    private String clubLogo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "school_id")
    private School school;

    @OneToOne()
    @JoinColumn(name="leader_student_id")
    private Student clubLeader;

    @OneToOne()
    @JoinColumn(name="coLeader_student_id")
    private Student clubCoLeader;

    @ManyToMany(mappedBy = "clubs")
    private List<Student> students;

    @OneToMany(mappedBy = "club", targetEntity = Event.class, cascade = CascadeType.ALL)
    private List<Event> events;

    @OneToMany(mappedBy = "club", targetEntity = Announcement.class, cascade = CascadeType.ALL)
    private List<Announcement> announcements;

    @ManyToMany()
    @JoinTable(name = "club_keywords", joinColumns = { @JoinColumn(name="club_id")},
            inverseJoinColumns = {@JoinColumn(name="keyword_id")})
    private List<Keyword> keywords;

    public Club(){

    }

    public Club(String name, String info, String type, String clubLogo, School school, Student clubLeader, Student clubCoLeader) {
        this.name = name;
        this.info = info;
        this.type = type;
        this.clubLogo = clubLogo;
        this.school = school;
        this.clubLeader = clubLeader;
        this.clubCoLeader = clubCoLeader;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClubLogo() {
        return clubLogo;
    }

    public void setClubLogo(String clubLogo) {
        this.clubLogo = clubLogo;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Student getClubLeader() {
        return clubLeader;
    }

    public void setClubLeader(Student clubLeader) {
        this.clubLeader = clubLeader;
    }

    public Student getClubCoLeader() {
        return clubCoLeader;
    }

    public void setClubCoLeader(Student clubCoLeader) {
        this.clubCoLeader = clubCoLeader;
    }
}
