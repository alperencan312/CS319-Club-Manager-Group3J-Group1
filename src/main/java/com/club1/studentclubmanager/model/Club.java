package com.club1.studentclubmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    @Column(nullable = false)
    private boolean acceptOthers;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "school_id")
    private School school;

    @OneToOne()
    @JoinColumn(name="contact")
    private Student clubLeader;

    @OneToOne()
    @JoinColumn(name="coLeader_student_id")
    private Student clubCoLeader;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "clubs")
    private List<Student> students;

    @OneToMany(targetEntity = Event.class, cascade = CascadeType.ALL)
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

    @JsonProperty("clubId")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("clubName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("about")
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

    @JsonProperty("clubImg")
    public String getClubLogo() {
        return clubLogo;
    }

    public void setClubLogo(String clubLogo) {
        this.clubLogo = clubLogo;
    }


    public boolean isAcceptOthers() {
        return acceptOthers;
    }

    public void setAcceptOthers(boolean acceptOthers) {
        this.acceptOthers = acceptOthers;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @JsonProperty("contact")
    public Student getClubLeader() {
        return clubLeader;
    }

    public void setClubLeader(Student clubLeader) {
        this.clubLeader = clubLeader;
    }

    @JsonIgnore
    public Student getClubCoLeader() {
        return clubCoLeader;
    }

    public void setClubCoLeader(Student clubCoLeader) {
        this.clubCoLeader = clubCoLeader;
    }

    @JsonProperty("school")
    public String getSchoolName(){
        return this.school.getSchoolName();
    }

    @JsonProperty("schoolId")
    public Long getSchoolId(){
        return this.school.getId();
    }


    public List<Student> getStudents() {
        return students;
    }


    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @JsonProperty("activities")
    public List<Event> getEvents() {
        return events;
    }


    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }


    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
    }

    @JsonProperty("keyWords")
    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }


}
