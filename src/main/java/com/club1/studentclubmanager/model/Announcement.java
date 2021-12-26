package com.club1.studentclubmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "announcement")
public class Announcement {
    @Id
    @SequenceGenerator(
            name = "announcement_sequence",
            sequenceName = "announcement_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "announcement_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String announcementInfo;

    @Column(nullable = false)
    private Timestamp created_at;

    @ManyToOne(optional = false)
    @JoinColumn(name = "club_id")
    private Club club;

    public Announcement(){

    }

    public Announcement(String announcementInfo, Timestamp created_at, Club club) {
        this.announcementInfo = announcementInfo;
        this.created_at = created_at;
        this.club = club;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("announcmentDesc")
    public String getAnnouncementInfo() {
        return announcementInfo;
    }

    public void setAnnouncementInfo(String announcementInfo) {
        this.announcementInfo = announcementInfo;
    }

    @JsonProperty("sent")
    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @JsonIgnore
    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
