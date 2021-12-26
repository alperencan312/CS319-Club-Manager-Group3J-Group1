package com.club1.studentclubmanager.model;

import javax.persistence.*;
import java.security.Key;
import java.util.List;

@Entity
@Table(name = "keyword")
public class Keyword {
    @Id
    @SequenceGenerator(
            name = "keyword_sequence",
            sequenceName = "keyword_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "keyword_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String keyword;

    @ManyToMany(mappedBy = "keywords")
    private List<Club> clubs;

    public Keyword(){

    }

    public Keyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
