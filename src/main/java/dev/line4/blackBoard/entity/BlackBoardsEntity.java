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

}
