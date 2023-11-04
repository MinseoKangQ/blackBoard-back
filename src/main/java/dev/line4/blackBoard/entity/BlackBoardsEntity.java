package dev.line4.blackBoard.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
id long
title varchar
introduction varchar
email varchar
graduate_date localdatetime
url text

*/

@Entity
public class BlackBoardsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String title;
    @Column(length = 100)
    private String introduction;
    @Column(length = 255)
    private String email;
    @Column
    private LocalDateTime graduate_date;
    @Column(columnDefinition = "TEXT")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getGraduate_date() {
        return graduate_date;
    }

    public void setGraduate_date(LocalDateTime graduate_date) {
        this.graduate_date = graduate_date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
