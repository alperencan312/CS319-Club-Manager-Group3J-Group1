package com.club1.studentclubmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @SequenceGenerator(
            name = "event_sequence",
            sequenceName = "event_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Timestamp date;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String info;

    @ManyToOne(optional = false)
    @JoinColumn(name = "club_id")
    private Club club;

    @Column(nullable = true)
    private String duration;

    @Column(nullable = true)
    private String priority;

    private Long clubId;

    private String clubLogo;

    private String time;

    public Event(){

    }
    public Event(String name, Timestamp date, String location, String info, Club club, String duration) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.info = info;
        this.club = club;
        this.duration = duration;
    }

    @JsonProperty("activityId")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("start")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("information")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @JsonProperty("clubId")
    public Long getClubsId(){
        return this.club.getId();
    }

    @JsonIgnore
    public Club getClub() {
        return club;
    }

    public Long getClubId(){
        return this.getClub().getId();
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @JsonProperty("url")
    public String getClubLogo(){
        return this.getClub().getClubLogo();
    }

    @JsonProperty("time")
    public String getTime(){
        return String.valueOf(this.getDate().getTime());
    }
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
